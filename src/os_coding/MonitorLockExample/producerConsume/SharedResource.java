package os_coding.MonitorLockExample.producerConsume;

import java.util.PriorityQueue;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> queue;
    private int capacity;

    public SharedResource(int capacity) {
        this.queue = new PriorityQueue<>(capacity);
        this.capacity = capacity;
    }

    public void produce(int item) throws InterruptedException {


            synchronized (this) {
                while (queue.size() > capacity) {
                    System.out.println("Buffer is full, Producer is waiting");
                    //all locks will be relased and the thread will wait
                    wait();
                }
                System.out.println("Producer produced-" + item);
                queue.add(item);
                //notify other threads that there is data to be consumed
                notify();
                Thread.sleep(1000);
            }

    }

    public void consume() throws InterruptedException {

            synchronized (this) {
                while (queue.isEmpty()) {
                    System.out.println("Buffer is empty, Consumer is waiting");
                    wait();
                }
                int consumed = queue.poll();
                System.out.println("Consumer consumed-" + consumed);
                notify();
                Thread.sleep(1000);
            }
    }

}
