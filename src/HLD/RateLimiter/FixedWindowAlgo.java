package HLD.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowAlgo {


    private final int LIMIT; // e.g., 10 requests
    private final long WINDOW_SIZE_MS; // e.g., 1 minute = 60000 ms
    private final ConcurrentHashMap<String, UserRequest> requestCounts = new ConcurrentHashMap<>();

    public FixedWindowAlgo(int limit, long windowSizeMs) {
        this.LIMIT = limit;
        this.WINDOW_SIZE_MS = windowSizeMs;
    }

    public boolean isAllowed(String userId) {
        long currentWindow = System.currentTimeMillis() / WINDOW_SIZE_MS;
        requestCounts.compute(userId, (key, entry) -> {
            if (entry == null || entry.window != currentWindow) {
                return new UserRequest(currentWindow, 1);
            }
            entry.count++;
            return entry;
        });

        return requestCounts.get(userId).count <= LIMIT;
    }

    static class UserRequest {
        long window;
        int count;

        UserRequest(long window, int count) {
            this.window = window;
            this.count = count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowAlgo limiter = new FixedWindowAlgo(5, 10000); // 5 req/10 sec
        for (int i = 0; i < 7; i++) {
            System.out.println("Request " + i + " allowed: " + limiter.isAllowed("user1"));
        }
    }
}
