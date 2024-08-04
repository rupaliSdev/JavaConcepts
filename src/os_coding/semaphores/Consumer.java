package os_coding.semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{



    Queue<Object> store;
    int cap;
    String name;
    Semaphore ps;
    Semaphore cs;

    Consumer(Queue<Object> store, int cap, String name, Semaphore ps, Semaphore cs){
        this.store = store;
        this.cap = cap;
        this.name = name;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {

        try {
            while (true) {
                cs.acquire();
                System.out.println(name + " removing an object. Size " + store.size());
                store.remove();
                ps.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
