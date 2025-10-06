package os_coding.ThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactor implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        return th;
    }
}
