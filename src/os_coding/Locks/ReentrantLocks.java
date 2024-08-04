package os_coding.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

    public static void main(String[] args) {

    }
}

class SharedResourceEx1{
    boolean isAvailable=false;
    ReentrantLock lock=new ReentrantLock();

    public void producer(){
        try {
           lock.lock();
           isAvailable=true;
        }
        catch (Exception e){

        }
        finally {
            lock.unlock();
            System.out.println("Producer");
        }
    }
}
