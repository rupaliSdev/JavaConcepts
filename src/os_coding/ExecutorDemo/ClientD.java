package os_coding.ExecutorDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientD {
    public static void main(String[] args) {

        Executor executor= Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            PrintTheNumber pr=new PrintTheNumber(i);
            executor.execute(pr);
        }
       // PrintTheNumber pr=new PrintTheNumber(20);


    }
}
