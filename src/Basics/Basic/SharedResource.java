package Basics.Basic;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class SharedResource {

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
