package os_coding.Locks;

import Basics.Basic.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaitAndNotify {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        WaitAndNotify t = new WaitAndNotify();
        Thread t1= new Thread(()->{
            try {
                t.printEven(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2= new Thread(()->{
            try {
                t.printOdd(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        /*SharedResource sharedResource=new SharedResource();
        Thread t1= new Thread(()->{
            for(int i =1;i<=15;i++){
                try {
                    sharedResource.producer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2= new Thread(()->{
            for(int i =1;i<=15;i++){
                try {
                    sharedResource.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();*/


        Student st = new Student();
        System.out.println(st.getClass().getName());
        Method[] f= st.getClass().getDeclaredMethods();
        Field[] fname= st.getClass().getDeclaredFields();


        for(Field f1:fname){
            f1.setAccessible(true);
            System.out.println(f1.getName());
            if(f1.getName().equals("id")){
                f1.set(st,1);
            }


        }

        System.out.println(st);
        st.display();


    }

    private synchronized  void printEven(int K) throws  InterruptedException{
        for(int i=1;i<=K;i++){
            if(i%2==0){
                System.out.println("Thread for even " +i);
                //Thread.sleep(1000);
                notify();
            }
            else{
                wait();
            }
        }
    }

    private synchronized void printOdd(int K) throws InterruptedException {
        for(int i=1;i<=K;i++){
            if(i%2!=0){
                System.out.println("Thread for odd " +i);
               // Thread.sleep(1000);
                notify();
            }
            else{
                wait();
            }
        }
    }


}
class SharedResource {

    BlockingQueue<Integer> blockingQueue;

    public SharedResource() {
        this.blockingQueue =new ArrayBlockingQueue<>(10) ;
    }

    public void producer(int item) throws InterruptedException {

        blockingQueue.put(item);
        System.out.println("Producer added item " + item);
           /* if(blockingQueue.size()<10) {
                blockingQueue.add(item);

                //notify();
            }
            else{
                System.out.println("Queue is full");
            }*/

    }

    public void consumer() throws InterruptedException {
        System.out.println("Consumer consumed item " + blockingQueue.take());
        //        blockingQueue.();

    }


}