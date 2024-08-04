package os_coding.ExecutorDemo;

public class PrintTheNumber implements  Runnable {
    int numberToPrint;

    public PrintTheNumber(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println("the no to be printed is "+numberToPrint + " at thread "+Thread.currentThread().getName());
    }
}
