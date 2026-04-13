package os_coding.multithreading.executor.callableDemo;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MergeSorter implements Callable<List<Integer>> {

    List<Integer> arraytoSort;
    MergeSorter(List<Integer> arraytoSort){
        this.arraytoSort=arraytoSort;
    }
    @Override
    public List<Integer> call() throws Exception {

        ExecutorService ext = Executors.newCachedThreadPool();

        if(arraytoSort.size()<=1){
            return arraytoSort;
        }
        int mid = arraytoSort.size()/2;

        List<Integer> leftArray = new ArrayList<>();

        for(int i=0;i<mid ;i++){
            leftArray.add(arraytoSort.get(i));
        }

        List<Integer> rightArray= new ArrayList<>();
        for(int i=mid;i< arraytoSort.size() ;i++){
            rightArray.add(arraytoSort.get(i));
        }
        MergeSorter leftmergesorter= new MergeSorter(leftArray);
        MergeSorter rightmergesorter = new MergeSorter(rightArray);
       // Future<List<Integer>> futureleftsortedArray =ext.submit(leftmergesorter);
        //Future<List<Integer>> futurerightsortedArray = ext.submit(rightmergesorter);
       // List<Integer> leftSorted =futureleftsortedArray.get();
       // List<Integer> rightSorted =futurerightsortedArray.get();

       List<Integer> leftSorted =leftmergesorter.call();
       List<Integer> rightSorted = rightmergesorter.call();
         int i=0;int j=0;
         List<Integer> sortedArray = new ArrayList<>();
         while(i<leftSorted.size() && j<rightSorted.size()){
             if(leftSorted.get(i)<=rightSorted.get(j)){
                 sortedArray.add(leftSorted.get(i));
                 i++;
             }
             else{
                 sortedArray.add(rightSorted.get(j));
                 j++;
             }
         }
        while(i<leftSorted.size() ){

            sortedArray.add(leftSorted.get(i));
            i++;

        }
        while(j<rightSorted.size()){

            sortedArray.add(rightSorted.get(j));
            j++;

        }
       return (List<Integer>)sortedArray;
    }
}
