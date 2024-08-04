package os_coding.MonitorLockExample;

public class MonitorLock{

    MonitorLock() {
        System.out.println("MonitorLock constructor");
    }

    public synchronized void method1() {
        try {
            System.out.println("method1");
            Thread.sleep(5000);
            System.out.println("method1, after sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void method2() {
        System.out.println("method2 , before synchronized block");
        synchronized (this){
            System.out.println("method2, inside synchronized block");
        }
    }

    public void  method3(){
        System.out.println("inside method 3");
    }

    public static void main(String[] args) {

        MonitorLock monitorLock = new MonitorLock();
        Thread t1 =new Thread(monitorLock::method1);

        Thread t2 = new Thread(()-> {
             monitorLock.method2();
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                monitorLock.method3();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
