package HLD.RateLimiter;

public class TokenBucketRateLimiter {
    private final int CAPACITY;
    private final int REFILL_RATE; // tokens per second
    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.CAPACITY = capacity;
        this.REFILL_RATE = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean isAllowed() {
        refill();
        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTime) / 1e9 * REFILL_RATE;
        tokens = Math.min(CAPACITY, tokens + tokensToAdd);
        lastRefillTime = now;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 2); // 5 tokens, 2/sec refill
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + " allowed: " + limiter.isAllowed());
            Thread.sleep(200);
        }
    }
}

