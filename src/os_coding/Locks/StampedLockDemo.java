package os_coding.Locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    private final StampedLock lock=new StampedLock();
    private int counter=0;

    public void incrementCounter(){
        long stamp= lock.readLock();
        try{

            System.out.println("Read lock acquired " + Thread.currentThread().getName());
            counter++;
            Thread.sleep(3000);
        }
        catch (Exception e){

        }
        finally {
            System.out.println("lock released");
            lock.unlockRead(stamp);
        }
    }
    public void decrementCounter(){

        long stamp=lock.writeLock();
        try {
            System.out.println("Write Lock acquired by: "+ Thread.currentThread().getName());
            counter--;
        }
        catch (Exception e){

        }
        finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock released by: "+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo =new StampedLockDemo();

        Thread th1= new Thread(stampedLockDemo::incrementCounter,"thread1");
        Thread th2=new Thread(stampedLockDemo::incrementCounter,"thread2");

        Thread th3=new Thread(stampedLockDemo::decrementCounter,"thread3");
        th1.start();
        th2.start();
        th3.start();
    }

}
