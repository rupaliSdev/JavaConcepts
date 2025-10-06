package os_coding.Locks;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread  t1= new Thread(()->{
            SharedResources sharedResources = new SharedResources();
            sharedResources.producer(lock);
        });

        Thread  t2= new Thread(()->{
            SharedResources sharedResources = new SharedResources();
            sharedResources.consumer(lock);
        });

        Thread  t3= new Thread(()->{
            SharedResources sharedResources = new SharedResources();
            sharedResources.consumer(lock);
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class SharedResources{

    boolean isAvailable = false;
    public void producer(ReadWriteLock lock){
       try{

              lock.writeLock().lock();
              System.out.println("Producer "+Thread.currentThread().getName());
              isAvailable = true;
       }
       catch (Exception e){
           e.printStackTrace();
       }
       finally {
           lock.writeLock().unlock();
           System.out.println("Exiting" + Thread.currentThread().getName());
       }
    }

    public void consumer(ReadWriteLock lock){
      try {
            lock.readLock().lock();
            Thread.sleep(1000);
            System.out.println("Consumer "+Thread.currentThread().getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.readLock().unlock();
            System.out.println("Exiting" + Thread.currentThread().getName());
      }
    }
}