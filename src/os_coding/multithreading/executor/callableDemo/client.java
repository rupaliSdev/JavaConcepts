package os_coding.multithreading.executor.callableDemo;
import java.lang.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("hello");

        List<Integer> lst = List.of(2,7,4,9,3);
        MergeSorter mst = new MergeSorter(lst);
        ExecutorService ext = Executors.newCachedThreadPool();
        Future<List<Integer>> futuresortedArray =ext.submit(mst);
        List<Integer> sortedArray = futuresortedArray.get();
       System.out.print(sortedArray);
       ext.shutdown();
        }


}
