package os_coding.synchronization.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class TimedLockingAndInterrupt {

    final ReentrantLock lock=new ReentrantLock();

    public void doSomeThing(){

        try{
            lock.lock();

//            /lock.lockInterruptibly();
            try {
                System.out.println("Lock acquired by " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
            finally {
                lock.unlock();
            }

        }
        catch (InterruptedException e){
            System.out.println("Thread is interrupted in doSomething " +e.getMessage());
        }


    }
    public static void main(String[] args) {

        TimedLockingAndInterrupt example=new TimedLockingAndInterrupt();
        Thread thread = new Thread(example::doSomeThing);
        thread.start();

        try {
            Thread.sleep(500);

        }
        catch (InterruptedException e){
            System.out.println("Thread is interrupted " +e.getMessage());
        }
        thread.interrupt();

    }
}


