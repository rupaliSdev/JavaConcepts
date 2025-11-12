package os_coding.MonitorLockExample.producerConsume;

public class Client {

    public static void main(String[] args) {

        SharedResource sharedResource=new SharedResource(2);

        Thread producerThread = new Thread(()->{
            for(int i=1;i<=6;i++){
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            for(int i=1;i<=6;i++){
                try {
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
