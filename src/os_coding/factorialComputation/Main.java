package os_coding.factorialComputation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(3435L, 35435L, 2324L,
                4656L, 23L, 5556L);

        List<FactorialCompuation> factorialThreads = new ArrayList<>();


        for(long n:inputNumbers){
            factorialThreads.add(new FactorialCompuation(n));
        }
        Thread t1 = new Thread(new DemoBlockedRunnable());
        t1.start();
        Thread t2 = new Thread(new DemoBlockedRunnable());
        t2.start();

        for(Thread fc :factorialThreads){
            System.out.println(fc.getState());
            fc.start();
            System.out.println(fc.getState());
        }
        for(Thread fc :factorialThreads){
            System.out.println(fc.getState());
           fc.join(2000);
        }


        for (FactorialCompuation t:factorialThreads){
            if(t.isFinished()){
                System.out.println(" next ");
            }
            else{
                System.out.println("Couldn't complete calc in 2s");
            }
        }
        Thread.sleep(2000);

        System.out.println(t2.getState());


    }

    static class DemoBlockedRunnable implements Runnable {
        @Override
    public void run() { commonResource();
    }
        public static synchronized void commonResource() {
            while(true) {
            // Infinite loop to mimic heavy processing
            // 't1' won't leave this method
            // when 't2' try to enter this
        } }
    }
}
