package HLD.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowCounterRateLimiter {
    private final int LIMIT;
    private final long WINDOW_SIZE_MS;
    private final ConcurrentHashMap<String, WindowCounter> counters = new ConcurrentHashMap<>();

    public SlidingWindowCounterRateLimiter(int limit, long windowSizeMs) {
        this.LIMIT = limit;
        this.WINDOW_SIZE_MS = windowSizeMs;
    }

    public boolean isAllowed(String userId) {
        long now = System.currentTimeMillis();
        long currentWindow = now / WINDOW_SIZE_MS;
        long prevWindow = currentWindow - 1;

        counters.putIfAbsent(userId, new WindowCounter());
        WindowCounter counter = counters.get(userId);

        counter.cleanup(currentWindow);

        double weightedCount = counter.getWeightedCount(now, WINDOW_SIZE_MS);
        if (weightedCount >= LIMIT) {
            return false;
        }

        counter.increment(currentWindow);
        return true;
    }

    static class WindowCounter {
        long currentWindow;
        int currentCount;
        long prevWindow;
        int prevCount;

        void cleanup(long newWindow) {
            if (newWindow != currentWindow) {
                prevWindow = currentWindow;
                prevCount = currentCount;
                currentWindow = newWindow;
                currentCount = 0;
            }
        }

        void increment(long window) {
            if (window == currentWindow) {
                currentCount++;
            }
        }

        double getWeightedCount(long now, long windowSizeMs) {
            long timeInCurrent = now % windowSizeMs;
            double weight = (double)(windowSizeMs - timeInCurrent) / windowSizeMs;
            return currentCount + prevCount * weight;
        }
    }
}
