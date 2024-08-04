package os_coding.MonitorLockExample;

public class Client {
    public static void main(String[] args) {


        ItemStore itemStore = new ItemStore();

        Thread producerThread = new Thread(()->{
            itemStore.putItem(20);
        });
        Thread consumerThread = new Thread(()->{
            itemStore.getItem();
        });

        producerThread.setPriority(Thread.MAX_PRIORITY);
        producerThread.start();

        consumerThread.start();

//        consumerThread.setDaemon(true);


        /*A daemon thread in programming is a background thread that runs continuously and performs tasks
        like garbage collection or monitoring. Unlike regular (or "user") threads,
        daemon threads do not prevent the JVM (Java Virtual Machine) or the application from exiting.
        When all user threads have finished executing, the JVM terminates all daemon threads and shuts down

        Daemon threads are useful in scenarios where you need to perform low-priority background tasks, such as:

Garbage Collection: JVM's garbage collector is typically implemented as a daemon thread.
Background Monitoring: Monitoring system resources, network connections, or other application metrics.
Housekeeping Tasks: Performing periodic clean-up operations like clearing caches or temporary files.
.
*/    }
}
