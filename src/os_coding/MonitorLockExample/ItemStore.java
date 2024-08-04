package os_coding.MonitorLockExample;

public class ItemStore {

    private int item;
    private static boolean isItemAvailable = false;

    public synchronized void putItem(int item) {
        System.out.println("Inside putItem");
        while (!isItemAvailable) {

                System.out.println("producer adding item");

                this.item = item;
                isItemAvailable = true;
                System.out.println(isItemAvailable);

        }
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("done from putItem");
    }

    public synchronized int getItem() {
        System.out.println("Inside getItem "+ isItemAvailable);
        while (isItemAvailable) {

                System.out.println("consumer consuming item");

                isItemAvailable = false;

        }

        notify();
        return item;
    }
}
