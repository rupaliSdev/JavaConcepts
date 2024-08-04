package os_coding.threaddemo3;

public class client {

    public static void main(String[] args) throws InterruptedException {
        count c= new count(0);
        Thread t1 =new Thread(new Adder(c));
        Thread t2 =new Thread(new subtractor(c));

        t1.start();
        t2.start();

        t2.join();
        t1.join();


        Thread.sleep(1000);
        System.out.println(c.val);

    }
}
