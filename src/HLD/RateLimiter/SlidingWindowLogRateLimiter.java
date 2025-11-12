package HLD.RateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowLogRateLimiter {
    private final int LIMIT;
    private final long WINDOW_SIZE_MS;
    private final ConcurrentHashMap<String, Deque<Long>> userLogs = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(int limit, long windowSizeMs) {
        this.LIMIT = limit;
        this.WINDOW_SIZE_MS = windowSizeMs;
    }

    public boolean isAllowed(String userId) {
        long now = System.currentTimeMillis();
        userLogs.putIfAbsent(userId, new ArrayDeque<>());
        Deque<Long> timestamps = userLogs.get(userId);

        // Remove timestamps outside the window
        while (!timestamps.isEmpty() && now - timestamps.peekFirst() >= WINDOW_SIZE_MS) {
            timestamps.pollFirst();
        }

        if (timestamps.size() < LIMIT) {
            timestamps.addLast(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowLogRateLimiter limiter = new SlidingWindowLogRateLimiter(3, 10000); // 3 req/10 sec
        for (int i = 0; i < 5; i++) {
            System.out.println("Request " + i + " allowed: " + limiter.isAllowed("user1"));
        }

        try {
            Thread.sleep(10000); // Wait for the window to pass
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 5; i++) {
            System.out.println("Request " + i + " allowed: " + limiter.isAllowed("user1"));
        }


    }
}
