package os_coding.ExecutorDemo;


import java.util.concurrent.*;
import java.util.concurrent.Executors;

public class client {

    public static void main(String[] args){

        //creating executor(threadpool) of size 10
       //Executor executor = Executors.newFixedThreadPool(10);
       ExecutorService exservice = Executors.newCachedThreadPool();
       int count =0;
        System.out.println("hello");
        for(int i=1;i<=100;i++){
            PrintTheNumber ptn = new PrintTheNumber(i);

            if(i==5 || i==10 || i==25){
                System.out.println("hello");
            }
            //executor.execute(ptn);
            exservice.execute(ptn);
            count++;
        }

       // exservice.shutdown();
        //System.out.println(count);


    }
}
