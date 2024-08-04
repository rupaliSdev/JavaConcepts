package os_coding.CallableFutures;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor= Executors.newCachedThreadPool();

        MergeSorter mergeSorter= new MergeSorter(List.of(4,5,7,2,3,1,8), executor);

        Future<List<Integer>> futureArrayList= executor.submit(mergeSorter);
        System.out.println(futureArrayList.get());


        executor.shutdown();


    }
}
