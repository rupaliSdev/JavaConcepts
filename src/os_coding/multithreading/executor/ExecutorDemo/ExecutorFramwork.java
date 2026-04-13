package os_coding.multithreading.executor.ExecutorDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramwork {

    public static void main(String[] args) {

        //uses unbounded queue
        ExecutorService fixedThread = Executors.newFixedThreadPool(3);


/*
similar to
new ThreadPoolExecutor(
                5,                      // core pool size
                5,                      // max pool size
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()   // ❗ unbounded queue
        );*/
        for (int i = 0; i <= 10; i++) {
            fixedThread.submit(() -> {
                System.out.println("hello" + Thread.currentThread().getName()
                );
            });
        }
        fixedThread.shutdown();


    }
}
