package os_coding.AtomicIntegerEx;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemResource {
    Counter counter;

    public ItemResource(Counter counter) {
        this.counter = counter;
    }

    public void increment() {
       counter.atomicInteger.incrementAndGet();
    }

    public void decrement() {
        counter.atomicInteger.decrementAndGet();
    }

    public int getValue() {
        return counter.atomicInteger.get();
    }

}
class Counter {
    AtomicInteger atomicInteger=new AtomicInteger(0);
}
