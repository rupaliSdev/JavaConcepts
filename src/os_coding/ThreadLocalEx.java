package os_coding;

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
    }
}
