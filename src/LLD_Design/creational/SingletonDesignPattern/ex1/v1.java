package LLD_Design.creational.SingletonDesignPattern.ex1;

public class v1 {

    public static void main(String[] args) {
        ThreadPool threadPool= ThreadPool.getInstance();
        Thread t1= new Thread();
        threadPool.execute(t1);
    }
}
