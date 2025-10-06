package os_coding.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class FairnessDemo {
    ReentrantLock fairlock= new ReentrantLock(true);
    ReentrantLock unfairLock=new ReentrantLock(false);

    public static void main(String[] args) {
        FairnessDemo fairnessDemo=new FairnessDemo();
        Runnable fairTask=()->{

                fairnessDemo.doFairThing();


        };

        Runnable unfairTask=()->{

                fairnessDemo.doUnFairThing();


        };

        Thread[] fairThreads= new Thread[5];
        Thread[] unFairThreads= new Thread[5];

        for(int i=0;i<5;i++){
            fairThreads[i] =new Thread(fairTask," FairThread-"+i);
            unFairThreads[i]=new Thread(unfairTask," unFairThread"+i);
        }

        for(Thread t:fairThreads){
            t.start();
        }
        for(Thread t:unFairThreads){
            t.start();
        }

       try{
          for (Thread t:fairThreads){
              t.join();
          }
          for(Thread t:unFairThreads){
              t.join();
          }

       }catch (Exception e){
           Thread.currentThread().interrupt();
       }

    }

    public void doFairThing(){
        fairlock.lock();
        try {

            System.out.println(Thread.currentThread().getName()+" Acquired Faired Lock");
            Thread.sleep(100);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            fairlock.unlock();
        }
    }

    public void doUnFairThing(){
        unfairLock.lock();
        try {

            System.out.println(Thread.currentThread().getName()+" Acquired unFaired Lock");
            Thread.sleep(100);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            unfairLock.unlock();
        }
    }


}
