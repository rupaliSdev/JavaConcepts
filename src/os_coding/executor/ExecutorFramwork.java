package os_coding.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramwork {

    public static void main(String[] args) {
        ExecutorService fixedThread= Executors.newFixedThreadPool(3);
        for(int i =0;i<=10;i++){
            fixedThread.submit(()->{
                System.out.println("hello" + Thread.currentThread().getName()
                );
            });
        }
        fixedThread.shutdown();
    }
}
