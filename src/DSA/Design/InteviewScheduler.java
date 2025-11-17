package DSA.Design;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Full-featured interview scheduler.
 * Features:
 *  - OOP design with InterviewerPool, CandidateQueue, Scheduler, ResultDispatcher
 *  - Simulated-time and Real-time modes (configurable)
 *  - Millisecond precision for durations and delays
 *  - Skill-based matching per round
 *  - Interviewer rest time, per-round durations configurable
 *  - Multi-day working window support (skip nights/weekends)
 *  - Thread-safe: uses concurrent collections and atomic timestamps
 *  - Produces: Gantt-style timeline, time-slot table, candidate wait times, interviewer idle times
 *
 * To run simulation: run main() which demonstrates all features.
 */
class InterviewScheduler {

    // ------------------------- Domain classes --------------------------------
    public static class Interviewer {
        final int id;
        final String name;
        final Set<String> skills;
        final AtomicLong availableAt = new AtomicLong(0); // millis
        // track idle time and assignments
        final List<TimelineEntry> timeline = Collections.synchronizedList(new ArrayList<>());

        public Interviewer(int id, String name, Collection<String> skills) {
            this.id = id;
            this.name = name;
            this.skills = new HashSet<>(skills);
        }

        @Override
        public String toString() {
            return "I" + id + "(" + name + ")";
        }
    }

    public static class Candidate {
        final int id;
        final String name;
        volatile int round = 1;
        volatile String status = "IN_PROCESS"; // IN_PROCESS / SELECTED / REJECTED
        long arrivalTime; // millis when candidate entered queue (simulation)
        // requiredSkillPerRound: index 1-based round -> skill
        final Map<Integer, String> requiredSkillPerRound = new HashMap<>();
        // store timeline for this candidate
        final List<TimelineEntry> timeline = Collections.synchronizedList(new ArrayList<>());

        public Candidate(int id, String name, long arrivalTime) {
            this.id = id;
            this.name = name;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public String toString() {
            return "C" + id + "(" + name + ")";
        }
    }

    public static class TimelineEntry {
        final long start; // millis
        final long end;   // millis
        final String label; // e.g., "C1-R1"
        final int interviewerId;

        public TimelineEntry(long start, long end, String label, int interviewerId) {
            this.start = start;
            this.end = end;
            this.label = label;
            this.interviewerId = interviewerId;
        }
    }

    // ------------------------ Scheduler Config --------------------------------
    public static class Config {
        public enum Mode { SIMULATION, REALTIME }

        Mode mode = Mode.SIMULATION;
        long interviewDurationMs = TimeUnit.MINUTES.toMillis(1);
        long restDurationMs = TimeUnit.MINUTES.toMillis(15);
        long resultDelayMs = TimeUnit.MINUTES.toMillis(30);
        // working window (local time), e.g., 10:00 - 18:00
        LocalTime workStart = LocalTime.of(10, 0);
        LocalTime workEnd = LocalTime.of(18, 0);
        ZoneId zone = ZoneId.systemDefault();
        boolean skipWeekends = true;

        @Override
        public String toString() {
            return "Config{" + "mode=" + mode + ", interviewDurationMs=" + interviewDurationMs +
                    ", restDurationMs=" + restDurationMs + ", resultDelayMs=" + resultDelayMs +
                    ", workStart=" + workStart + ", workEnd=" + workEnd + '}';
        }
    }

    // ------------------------ Scheduler ----------------------------------------
    public static class Scheduler {

        private final Config config;
        private final List<Interviewer> interviewersList;

        // For thread-safety and ordering by availableAt
        private final PriorityBlockingQueue<Interviewer> interviewerQueue;

        // candidate queue (thread-safe)
        private final ConcurrentLinkedQueue<Candidate> candidateQueue = new ConcurrentLinkedQueue<>();

        // timeline entries across all interviewers
        private final List<TimelineEntry> allTimeline = Collections.synchronizedList(new ArrayList<>());

        // result executor and scheduler
        private final ScheduledExecutorService resultScheduler = Executors.newScheduledThreadPool(4);
        private final ExecutorService resultHandlerPool = Executors.newFixedThreadPool(4);

        // simulation clock (only used in SIMULATION mode)
        private final AtomicLong simulatedTime = new AtomicLong(0);

        // track candidate wait times
        private final Map<Integer, Long> candidateFirstAssignTime = new ConcurrentHashMap<>();
        private final Map<Integer, Long> candidateTotalWait = new ConcurrentHashMap<>();

        public Scheduler(Config config, List<Interviewer> interviewers) {
            this.config = config;
            this.interviewersList = new ArrayList<>(interviewers);

            this.interviewerQueue = new PriorityBlockingQueue<>(interviewers.size(), Comparator.comparingLong(i -> i.availableAt.get()));
            interviewerQueue.addAll(interviewers);
        }

        // Add candidate (arrives at current simulation time or real time)
        public void addCandidate(Candidate c) {
            candidateQueue.add(c);
            candidateTotalWait.put(c.id, 0L);
            candidateFirstAssignTime.putIfAbsent(c.id, -1L);
        }

        // Main scheduling loop (runs until queue empty). This is synchronous in SIMULATION mode.
        public List<Candidate> runScheduling(int maxRounds) throws InterruptedException {
            List<Candidate> selected = Collections.synchronizedList(new ArrayList<>());

            while (!candidateQueue.isEmpty()) {
                Candidate candidate = candidateQueue.poll();
                if (candidate == null) break;

                // pick the next available interviewer
                Interviewer interviewer = interviewerQueue.poll(1, TimeUnit.SECONDS);
                if (interviewer == null) {
                    // no interviewer currently -- requeue candidate briefly
                    candidateQueue.add(candidate);
                    continue;
                }

                long now = nowMillis();

                // ensure interviewer availability and working window
                long interviewerAvail = interviewer.availableAt.get();
                if (interviewerAvail > now) {
                    // advance clock in simulation or wait in real time
                    if (config.mode == Config.Mode.SIMULATION) {
                        simulatedTime.set(interviewerAvail);
                        now = interviewerAvail;
                    } else {
                        long wait = interviewerAvail - now;
                        Thread.sleep(wait);
                        now = nowMillis();
                    }
                }

                // if outside working hours, move to next valid slot
                now = fixToWorkingWindow(now, interviewer);

                // skill matching: check if interviewer has the required skill for candidate.round
                String requiredSkill = candidate.requiredSkillPerRound.getOrDefault(candidate.round, null);
                if (requiredSkill != null && !interviewer.skills.contains(requiredSkill)) {
                    // interviewer cannot interview this round for this candidate. Put candidate back and try next interviewer
                    candidateQueue.add(candidate);
                    interviewerQueue.add(interviewer);
                    // small simulation time advance to avoid tight loop
                    if (config.mode == Config.Mode.SIMULATION) simulatedTime.addAndGet(1);
                    continue;
                }

                // mark first assign time
                long finalNow = now;
                candidateFirstAssignTime.computeIfPresent(candidate.id, (k, v) -> v == -1L ? finalNow : v);

                // schedule interview
                long start = now;
                long end = start + config.interviewDurationMs;
                String label = candidate.toString() + "-R" + candidate.round;

                TimelineEntry entry = new TimelineEntry(start, end, label, interviewer.id);
                interviewer.timeline.add(entry);
                candidate.timeline.add(entry);
                allTimeline.add(entry);

                // update interviewer availableAt (end + rest), thread-safely
                interviewer.availableAt.set(end + config.restDurationMs);

                // advance simulated time or real clock by interview duration (for scheduler)
                if (config.mode == Config.Mode.SIMULATION) {
                    simulatedTime.set(end);
                } else {
                    // in real time mode, interview actually takes place asynchronously (we'll wait only for results)
                }

                // schedule result asynchronously
                scheduleResult(candidate, interviewer, maxRounds, selected);

                // put interviewer back into the queue (so others can use him when available)
                interviewerQueue.add(interviewer);
            }

            // Wait for pending results to finish before returning selected list.
            // We can't easily know how many are pending; sleep until roughly all results should arrive.
            // In real system we'd track futures. For demonstration, wait for a safe period.
            Thread.sleep(Math.max(1000, config.resultDelayMs + 200));

            shutdownExecutors();
            return selected;
        }

        private void shutdownExecutors() {
            try {
                resultScheduler.shutdown();
                resultScheduler.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException ignored) {}
            try {
                resultHandlerPool.shutdown();
                resultHandlerPool.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException ignored) {}
        }

        private void scheduleResult(Candidate candidate, Interviewer interviewer, int maxRounds, List<Candidate> selected) {
            // capture start time for wait calculation
            long assign = nowMillis();
            candidateTotalWait.compute(candidate.id, (k, v) -> v + Math.max(0, assign - candidate.arrivalTime));

            // schedule asynchronous result after config.resultDelayMs
            resultScheduler.schedule(() -> {
                // simple pass/fail logic: even id -> SELECTED, odd -> REJECTED (as example). Replace with real evaluation.
                String status = (candidate.id % 2 == 0) ? "SELECTED" : "REJECTED";
                candidate.status = status;

                // handle result in thread pool to avoid blocking scheduler
                resultHandlerPool.submit(() -> {
                    if ("SELECTED".equals(status)) {
                        if (candidate.round >= maxRounds) {
                            selected.add(candidate);
                        } else {
                            candidate.round++;
                            // candidate is ready for next round; arrivalTime becomes current scheduler time
                            candidate.arrivalTime = nowMillis(); // note: arrivalTime was final earlier; to update, field should not be final - adjust
                            candidateQueue.add(candidate);
                        }
                    }
                });
            }, config.resultDelayMs, TimeUnit.MILLISECONDS);
        }

        // adjust a timestamp to within working window; if outside, move to next valid work start
        private long fixToWorkingWindow(long timestamp, Interviewer interviewer) {
            if (config.mode == Config.Mode.SIMULATION) {
                // interpret timestamp as millis since simulation epoch; map to LocalDateTime via epoch day 1970-01-01 + offset
                Instant inst = Instant.ofEpochMilli(timestamp);
                ZonedDateTime zdt = ZonedDateTime.ofInstant(inst, config.zone);
                LocalTime lt = zdt.toLocalTime();
                DayOfWeek dow = zdt.getDayOfWeek();

                if (config.skipWeekends && (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY)) {
                    // move to next Monday at workStart
                    int daysToAdd = dow == DayOfWeek.SATURDAY ? 2 : 1;
                    zdt = zdt.plusDays(daysToAdd).with(config.workStart);
                    return zdt.toInstant().toEpochMilli();
                }

                if (lt.isBefore(config.workStart)) {
                    zdt = zdt.with(config.workStart);
                    return zdt.toInstant().toEpochMilli();
                }
                if (lt.isAfter(config.workEnd) || lt.equals(config.workEnd)) {
                    // move to next day at workStart
                    zdt = zdt.plusDays(1).with(config.workStart);
                    if (config.skipWeekends) {
                        while (zdt.getDayOfWeek() == DayOfWeek.SATURDAY || zdt.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            zdt = zdt.plusDays(1);
                        }
                    }
                    return zdt.toInstant().toEpochMilli();
                }
                return timestamp;
            } else {
                // REALTIME mode: check system clock local time
                ZonedDateTime zdt = ZonedDateTime.now(config.zone);
                LocalTime now = zdt.toLocalTime();
                if (now.isBefore(config.workStart)) {
                    Duration d = Duration.between(now, config.workStart);
                    try { Thread.sleep(d.toMillis()); } catch (InterruptedException ignored) {}
                    return nowMillis();
                }
                if (now.isAfter(config.workEnd) || now.equals(config.workEnd)) {
                    // sleep until next workStart
                    ZonedDateTime next = zdt.plusDays(1).with(config.workStart);
                    if (config.skipWeekends) {
                        while (next.getDayOfWeek() == DayOfWeek.SATURDAY || next.getDayOfWeek() == DayOfWeek.SUNDAY) {
                            next = next.plusDays(1);
                        }
                    }
                    long sleep = Duration.between(ZonedDateTime.now(config.zone), next).toMillis();
                    try { Thread.sleep(Math.max(0, sleep)); } catch (InterruptedException ignored) {}
                    return nowMillis();
                }
                return nowMillis();
            }
        }

        private long nowMillis() {
            return config.mode == Config.Mode.SIMULATION ? simulatedTime.get() : System.currentTimeMillis();
        }

        // -------------------------------------------------
        // Reporting utilities
        // -------------------------------------------------

        public void printGantt() {
            // group entries by interviewer
            Map<Integer, List<TimelineEntry>> byInterviewer = allTimeline.stream().collect(Collectors.groupingBy(e -> e.interviewerId));
            System.out.println("\nGANTT TIMELINE (ms):");
            for (Interviewer i : interviewersList) {
                List<TimelineEntry> t = byInterviewer.getOrDefault(i.id, Collections.emptyList());
                t.sort(Comparator.comparingLong(e -> e.start));
                StringBuilder sb = new StringBuilder(i + ": ");
                for (TimelineEntry e : t) sb.append("[").append(e.label).append("@").append(e.start).append("-" ).append(e.end).append("]");
                System.out.println(sb);
            }
        }

        public void printTimeSlotTable() {
            System.out.println("\nTime-slot Table (ms):");
            System.out.println(String.format("%-15s %-15s %-10s %-10s", "Start", "Interviewer", "Candidate", "Round"));
            List<TimelineEntry> sorted = new ArrayList<>(allTimeline);
            sorted.sort(Comparator.comparingLong(e -> e.start));
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
            for (TimelineEntry e : sorted) {
                System.out.printf("%-15d %-15s %-10s %-10s%n", e.start, "I" + e.interviewerId, e.label.split("-")[0], e.label.split("-R")[1]);
            }
        }

        public void printCandidateWaitTimes() {
            System.out.println("\nCandidate Wait Times (ms):");
            candidateTotalWait.forEach((k, v) -> System.out.println("C" + k + " waited " + v + " ms"));
        }

        public void printInterviewerIdleTimes() {
            System.out.println("\nInterviewer Idle Times (ms):");
            for (Interviewer i : interviewersList) {
                List<TimelineEntry> t = new ArrayList<>(i.timeline);
                t.sort(Comparator.comparingLong(e -> e.start));
                long idle = 0;
                long lastEnd = 0;
                for (TimelineEntry e : t) {
                    if (e.start > lastEnd) idle += (e.start - lastEnd);
                    lastEnd = Math.max(lastEnd, e.end);
                }
                System.out.println(i + " idle = " + idle + " ms");
            }
        }
    }

    // ------------------------ Demo / main --------------------------------------
    public static void main(String[] args) throws InterruptedException {
        // Setup config
        Config cfg = new Config();
        cfg.mode = Config.Mode.SIMULATION; // change to REALTIME to use wall clock
        cfg.interviewDurationMs = TimeUnit.MINUTES.toMillis(1); // 1 minute
        cfg.restDurationMs = TimeUnit.MINUTES.toMillis(15); // 15 min rest
        cfg.resultDelayMs = TimeUnit.MINUTES.toMillis(30); // results after 30 min
        cfg.workStart = LocalTime.of(9, 0);
        cfg.workEnd = LocalTime.of(18, 0);
        cfg.skipWeekends = true;

        // Create interviewers with skills
        Interviewer i1 = new Interviewer(1, "Alice", Arrays.asList("Java", "SystemDesign"));
        Interviewer i2 = new Interviewer(2, "Bob", Arrays.asList("Java", "DB"));
        Interviewer i3 = new Interviewer(3, "Carol", Arrays.asList("SystemDesign", "ML"));

        List<Interviewer> interviewers = Arrays.asList(i1, i2, i3);

        Scheduler scheduler = new Scheduler(cfg, interviewers);

        // Populate candidates with skill requirements for rounds
        long simStart = 0L; // epoch for simulation
        Candidate c1 = new Candidate(1, "Rupali", simStart);
        c1.requiredSkillPerRound.put(1, "Java");
        c1.requiredSkillPerRound.put(2, "SystemDesign");

        Candidate c2 = new Candidate(2, "Aman", simStart);
        c2.requiredSkillPerRound.put(1, "Java");
        c2.requiredSkillPerRound.put(2, "DB");

        Candidate c3 = new Candidate(3, "Neha", simStart);
        c3.requiredSkillPerRound.put(1, "SystemDesign");

        Candidate c4 = new Candidate(4, "Karan", simStart);
        c4.requiredSkillPerRound.put(1, "Java");

        Candidate c5 = new Candidate(5, "Sia", simStart);
        c5.requiredSkillPerRound.put(1, "ML");

        Arrays.asList(c1, c2, c3, c4, c5).forEach(scheduler::addCandidate);

        // Run scheduling for max 3 rounds
        List<Candidate> selected = scheduler.runScheduling(3);

        // Reporting
        scheduler.printGantt();
        scheduler.printTimeSlotTable();
        scheduler.printCandidateWaitTimes();
        scheduler.printInterviewerIdleTimes();

        System.out.println("\nSelected candidates (passed all rounds):");
        selected.forEach(c -> System.out.println(c + " status=" + c.status));
    }
}
