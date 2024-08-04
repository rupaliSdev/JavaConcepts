package jvm;

public class GCDemo {
    public static void main(String[] args) {

        GCDemo memoryTest = new GCDemo();
        memoryTest=null;

        System.gc();

//        Runtime.getRuntime().gc();
        System.out.println("Garbage collection is performed by JVM");

       /* Runtime runtime = Runtime.getRuntime();
        long availableBytes = runtime.totalMemory();
        System.out.println("Total memory is: " + availableBytes + " bytes.");

        availableBytes = runtime.freeMemory();
        System.out.println("Initial free memory: " + availableBytes + " bytes.");

        // Let's create some objects
        GCDemo memoryTest = new GCDemo();
        for (int i = 0; i < 1000; i++) {
            memoryTest.generateObjects();
        }

        availableBytes = runtime.freeMemory();
        System.out.println("Free memory after creating 1000 objects: " + availableBytes + " bytes.");

        // Invoke garbage collector
        runtime.gc();

        availableBytes = runtime.freeMemory();
        System.out.println("Free memory after invoking garbage collector: " + availableBytes + " bytes.");
   */ }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collection is performed by JVM");
    }
}
