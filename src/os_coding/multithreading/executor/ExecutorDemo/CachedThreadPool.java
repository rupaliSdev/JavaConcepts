package os_coding.multithreading.executor.ExecutorDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {

        Executor executor= Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            PrintTheNumber pr=new PrintTheNumber(i);
            executor.execute(pr);
        }
       // PrintTheNumber pr=new PrintTheNumber(20);


    }
}
