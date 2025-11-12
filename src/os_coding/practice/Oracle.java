package os_coding.practice;

public class Oracle {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(()->{
            System.out.println("hey i am rupali");
        });
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("hello");
    }
}