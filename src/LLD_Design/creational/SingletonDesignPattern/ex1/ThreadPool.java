package LLD_Design.creational.SingletonDesignPattern.ex1;

import java.util.concurrent.ExecutorService;

public class ThreadPool {

    private static volatile ThreadPool instance;
    private ExecutorService executorService;

    public static ThreadPool getInstance(){
        if(instance==null){
            synchronized (ThreadPool.class){
                if (instance==null){
                    instance=new ThreadPool();
                }

            }

        }
        return instance;
    }
    public void execute(Runnable task){
        executorService.execute(task);
    }

}
