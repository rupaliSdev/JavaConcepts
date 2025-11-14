package DSA.Design;


import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Data Structure Design Question- X interviewers and Y candidates - interview to be
// scheduled so that maximum interviews can be possible and candidate don't have to sit idle.
// After every interview interviewer need 15 min rest. and after a candidate is rejected no further rounds for him.
//I designed it through map and queue. Then they asked me to code.
public class InterviewDesign {

    static class Interviewer {
        int id;
        int availableAt;

        public Interviewer(int id, int availableAt) {
            this.id = id;
            this.availableAt = availableAt;
        }
    }

    static class Candidate{
        int id;
        int round;

        public Candidate(int id, int round) {
            this.id = id;
            this.round = round;
        }
    }

    private static final ScheduledExecutorService delayScheduler =
            Executors.newScheduledThreadPool(4);

    public static List<Candidate> scheduleInterviews(int interviewCounts, int candidateCount, int maxRounds){
        List<Candidate> selectedCandidates= new ArrayList<>();

        PriorityQueue<Interviewer> interviewers= new PriorityQueue<>((a,b)->a.availableAt- b.availableAt);
        for(int i =1;i<=interviewCounts;i++){
            interviewers.add(new Interviewer(i,0));
        }
        Queue<Candidate> candidates = new LinkedList<>();

        for(int i =1;i<=candidateCount;i++){
            interviewers.add(new Interviewer(i,1));
        }

        int interviewDuration = 30 ,rest = 15;
        while(!candidates.isEmpty()){

            Interviewer interviewer = interviewers.poll();
            Candidate candidate= candidates.poll();

            System.out.println("Round " + candidate.round +
                    " → Interviewer " + interviewer.id +
                    " interviews Candidate " + candidate +
                    " at time " + interviewer.availableAt + " min");

            CompletableFuture<String> resultFuture= scheduleResult(candidate);

            resultFuture.thenAccept((result)->{
                System.out.println(result);
                if(result.equals("SUCCESS")){
                    if(candidate.round==4){
                        selectedCandidates.add(candidate);
                    }
                    else{
                    candidate.round=candidate.round+1;
                    candidates.add(candidate);}
                }
            });

            interviewer.availableAt+= interviewDuration+rest;
            interviewers.add(interviewer);


        }
        return selectedCandidates;
    }

    private static CompletableFuture<String> scheduleResult(Candidate candidate) {

        CompletableFuture<String> resultFuture= new CompletableFuture<>();

        delayScheduler.schedule(()->{
            String status = Math.random()>0.5 ?"SELECTED":"REJECTED";
            resultFuture.complete(
                    "Result after 30 mins : Candidate "+candidate + " Round "+ candidate.round+ "->" + status);

        },30,TimeUnit.MINUTES);


        return resultFuture;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Scheduling Interviews...\n");

        List<Candidate> candidates=scheduleInterviews(3, 5,4);
        candidates.forEach((c)-> System.out.println(c));

        // Just keeping main alive to let async tasks complete
        Thread.sleep(TimeUnit.MINUTES.toMillis(31));
    }

}

