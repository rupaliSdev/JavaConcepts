package os_coding.threadDemo.threadDemo1;
//import java.lang.Runnable;
import java.lang.*;
public class PrintTheNumber implements Runnable{
    int numberToprint;
    PrintTheNumber(int num){
        this.numberToprint=num;
    }
    public void run(){
           System.out.println("Number is "+ numberToprint + " And thread name" +Thread.currentThread().getName());
    }

}
