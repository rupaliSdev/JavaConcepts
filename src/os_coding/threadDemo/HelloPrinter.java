package os_coding.threadDemo;
import java.lang.*;
public class HelloPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println(" hello thread ---"+ Thread.currentThread().getName());
        doSomething();
    }

    private void doSomething() {
        System.out.println("hello World thread ---"+ Thread.currentThread().getName());
    }
}
