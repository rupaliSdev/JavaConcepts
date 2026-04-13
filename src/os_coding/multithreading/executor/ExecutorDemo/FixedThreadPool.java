package os_coding.multithreading.executor.ExecutorDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {

        //creating executor(threadpool) of size 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        int count = 0;
        System.out.println("hello");
        for (int i = 1; i <= 100; i++) {
            PrintTheNumber ptn = new PrintTheNumber(i);

            if (i == 5 || i == 10 || i == 25) {
                System.out.println("hello");
            }
            //executor.execute(ptn);
            executor.execute(ptn);
            count++;
        }

        // exservice.shutdown();
        //System.out.println(count);


    }
}
