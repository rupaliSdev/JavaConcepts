package os_coding.Locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLocks {

    public static void main(String[] args) {

     SharedResourceEx1 resourceEx1= new SharedResourceEx1();

     Thread th1= new Thread(resourceEx1::consumer);
     Thread th2=new Thread(resourceEx1::consumer);

     SharedResourceEx1 resourceEx2= new SharedResourceEx1();

        Thread th3=new Thread(resourceEx2::consumer);
        th1.start();
        th2.start();
        th3.start();
    }
}

class SharedResourceEx1{
    boolean isAvailable=false;
//
//    If you want thread safety across all objects, you can make the lock static (shared by all instances).
    private static final ReadWriteLock lock=new ReentrantReadWriteLock();

    public void producer(){
        try {
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: "+ Thread.currentThread().getName());
            isAvailable=true;

        }
        catch (Exception e){

        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read Lock released by: "+ Thread.currentThread().getName());
        }
    }

    public void consumer(){

        try {
            lock.writeLock().lock();
            isAvailable=false;
            System.out.println("Write Lock acquired by: "+ Thread.currentThread().getName());
            //Thread.sleep(8000);
        }
        catch (Exception e){

        }
        finally {
            System.out.println("Write Lock released by: "+ Thread.currentThread().getName());

            lock.writeLock().unlock();

        }
    }
}
