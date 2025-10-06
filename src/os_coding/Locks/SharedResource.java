package os_coding.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable=false;
    ReentrantLock lock=new ReentrantLock();

    public void producer(){
        try {
            System.out.println("Producer "+Thread.currentThread().getName());
             lock.lock();
            isAvailable=true;

        }
        catch (Exception e){
             e.printStackTrace();
        }
        finally {
            lock.unlock();
            System.out.println("Producer");
        }
    }
}
