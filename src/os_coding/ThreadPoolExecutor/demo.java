package os_coding.ThreadPoolExecutor;

import java.util.concurrent.*;

public class demo {
    public static void main(String[] args) {

//        //
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
//        //new thread will be created and will perform the task.
//
//
//        Future<?> futureObj=executor.submit(()->{
//            System.out.println("this is the task ,which thread will execute");
//        });
//        System.out.println(futureObj.isDone());


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, // corePoolSize
                5, // maximumPoolSize
                1, // keepAliveTime
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), // work queue capacity
                new CustomThreadFactor(), // custom thread factory
                new CustomRejectedHandler() // custom rejection handler
        );


        poolExecutor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 25; i++) {
            poolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000); // Simulates task processing time
                    System.out.println("Thread name:" + Thread.currentThread().getName());
                } catch (Exception e) {}
            });
        }
        poolExecutor.shutdown();
    }
}

