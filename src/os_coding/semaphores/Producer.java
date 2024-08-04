package os_coding.semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{


    Queue<Object> Store;
    int cap;

    String name;
    Semaphore ps;
    Semaphore cs;

    Producer(Queue<Object> Store,int cap,String name,Semaphore ps,Semaphore cs){
        this.Store=Store;
        this.cap=cap;
        this.name=name;
        this.ps=ps;
        this.cs=cs;

    }

    @Override
    public void run() {

        while (true){
            try {
                ps.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(name + " adding an object. Size " + Store.size());
            Store.add(new Object());


            cs.release();
        }

    }
}
