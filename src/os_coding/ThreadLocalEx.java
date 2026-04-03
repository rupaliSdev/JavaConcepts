package os_coding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalEx {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocalObj= new ThreadLocal<>();

        threadLocalObj.set(Thread.currentThread().getName());

        Thread t1=new Thread(()->{
            threadLocalObj.set(Thread.currentThread().getName());
            System.out.println(threadLocalObj.get());
        });
        t1.start();
        System.out.println(threadLocalObj.get());




        Thread vt = Thread.startVirtualThread(()->{
            System.out.println("Running in: " + Thread.currentThread());
        });

        Thread vt1 = Thread.ofVirtual().start(()->
                        System.out.println("thread 2")
                );


        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 5; i++) {
                int taskId = i;

                executor.submit(() -> {
                    System.out.println(
                            "Task " + taskId +
                                    " executed by " +
                                    Thread.currentThread());
                });
            }
        }

        ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor();

        executor.submit(() -> {
//            String data = database.fetchData(); // blocking I/O
//            return data;
        });

//        Instead of blocking expensive OS threads, the JVM parks the virtual thread and
//        frees the carrier thread.
}
}


