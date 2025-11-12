package HLD.RateLimiter;

import java.util.concurrent.*;

public class LeakyBucketRateLimiter {
    private final int CAPACITY;
    private final int LEAK_RATE; // requests per second
    private final BlockingQueue<Long> queue;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.CAPACITY = capacity;
        this.LEAK_RATE = leakRate;
        this.queue = new ArrayBlockingQueue<>(capacity);

        scheduler.scheduleAtFixedRate(() -> {
            Long request = queue.poll();
            if (request != null) {
                System.out.println("Processing request at " + System.currentTimeMillis());
            }
        }, 0, 1000 / LEAK_RATE, TimeUnit.MILLISECONDS);
    }

    public boolean isAllowed() {
        return queue.offer(System.currentTimeMillis()); // reject if bucket full
    }

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketRateLimiter limiter = new LeakyBucketRateLimiter(5, 1); // 5 capacity, 1 req/sec
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + " allowed: " + limiter.isAllowed());
            Thread.sleep(200);
        }
    }
}

