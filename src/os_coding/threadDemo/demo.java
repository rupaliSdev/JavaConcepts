package os_coding.threadDemo;

public class demo {

    public static void main(String[] args){
        //which thread is executing
        System.out.println("hello "+ Thread.currentThread().getName());
        HelloPrinter hp = new HelloPrinter();
        Thread td = new Thread(hp);
        Thread t2 = new Thread(()->{
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        td.start();
        t2.start();
    }
}
