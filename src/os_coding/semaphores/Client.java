package os_coding.semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        Queue<Object> store = new ConcurrentLinkedQueue<>();
        int cap = 5;

        Semaphore ps = new Semaphore(cap);
        Semaphore cs = new Semaphore(0);

        Producer p1 = new Producer(store, cap, "p1", ps, cs);
        Producer p2 = new Producer(store, cap, "p2", ps, cs);
        Producer p3 = new Producer(store, cap, "p3", ps, cs);

        Consumer c1 = new Consumer(store, cap, "c1", ps, cs);
        Consumer c2 = new Consumer(store, cap, "c2", ps, cs);
        Consumer c3 = new Consumer(store, cap, "c3", ps, cs);
        Consumer c4 = new Consumer(store, cap, "c4", ps, cs);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);
        Thread t6 = new Thread(c3);
        Thread t7 = new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }
}
