package DSA.Design;


import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Data Structure Design Question- X interviewers and Y candidates - interview to be
// scheduled so that maximum interviews can be possible and candidate don't have to sit idle.
// After every interview interviewer need 15-min rest. and after a candidate is rejected no further rounds for him.
//I designed it through map and queue. Then they asked me to code.
public class InterviewDesign {

    static class Interviewer {
        int id;
        long availableAt;

        public Interviewer(int id, long availableAt) {
            this.id = id;
            this.availableAt = availableAt;
        }
    }

    static class Candidate {
        int id;
        int round;
        String status;

        public Candidate(int id) {
            this.id = id;
            this.round = 1;
            this.status = "IN_PROCESS";
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "id=" + id +
                    ", round=" + round +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    private static final ScheduledExecutorService delayScheduler = Executors.newScheduledThreadPool(4);

    public static List<Candidate> scheduleInterviews(int interviewCounts, int candidateCount, int maxRounds) {
        List<Candidate> selectedCandidates = new ArrayList<>();

        long currentTime = 0;
        PriorityQueue<Interviewer> interviewers = new PriorityQueue<>(Comparator.comparingLong(a -> a.availableAt));
        for (int i = 1; i <= interviewCounts; i++) {
            interviewers.add(new Interviewer(i, 0));
        }
        Queue<Candidate> candidates = new LinkedList<>();

        for (int i = 1; i <= candidateCount; i++) {
            candidates.offer(new Candidate(i));
        }

        long interviewDuration = 60_000, rest = 60_000;
        while (!candidates.isEmpty()) {

            Interviewer interviewer = interviewers.poll();
            Candidate candidate = candidates.poll();

            if (interviewer.availableAt > currentTime) {
                currentTime = interviewer.availableAt; // advance simulator
            }

            System.out.println("Round " + candidate.round + " → Interviewer " + interviewer.id + " interviews Candidate " + candidate.id + " at time " + interviewer.availableAt + " min");

            CompletableFuture<Candidate> resultFuture = scheduleResult(candidate);

            resultFuture.thenAccept((result) -> {
                if (candidate.status.equals("SELECTED")) {
                    if (candidate.round == maxRounds) {
                        selectedCandidates.add(candidate);
                    } else {
                        candidate.round++;
                        candidates.add(candidate);
                    }
                }
            });

            interviewer.availableAt = currentTime + interviewDuration + rest;
            interviewers.add(interviewer);

            currentTime += interviewDuration;


        }
        return selectedCandidates;
    }

    private static CompletableFuture<Candidate> scheduleResult(Candidate candidate) {

        CompletableFuture<Candidate> resultFuture = new CompletableFuture<>();


        delayScheduler.schedule(() -> {
            String status = candidate.id % 2 == 0 ? "SELECTED" : "REJECTED";
            candidate.status = status;
            //System.out.println("Result after 30 mins : Candidate " + candidate.id + " Round " + candidate.round + "->" + status);
            resultFuture.complete(candidate);

        }, 1, TimeUnit.MICROSECONDS);


        return resultFuture;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Scheduling Interviews...\n");

        List<Candidate> candidates = scheduleInterviews(3, 5, 4);
        candidates.forEach(System.out::println);
        Thread.sleep(TimeUnit.MINUTES.toMillis(31));
    }

}

