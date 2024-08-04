package os_coding.CallableFutures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class MergeSorter  implements Callable<List<Integer>> {


    List<Integer> lst;
    ExecutorService executorService;

    public MergeSorter(List<Integer> lst, ExecutorService executorService) {
        this.lst = lst;
        this.executorService=executorService;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(lst.size()<=1){
            return lst;
        }

        int mid = lst.size()/2;

        List<Integer> leftArray = lst.subList(0,mid);
        List<Integer> rightArray =lst.subList(mid,lst.size());

        MergeSorter leftMergeSorter = new MergeSorter(leftArray,executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightArray,executorService);

        List<Integer> leftSorted = executorService.submit(leftMergeSorter).get();
        List<Integer> rightSorted = executorService.submit(rightMergeSorter).get();
        List<Integer> sortedArray=new ArrayList<>();
        int i=0,j=0;
        while(i<=leftSorted.size()-1 && j<=leftSorted.size()-1){
            if(leftSorted.get(i)<=rightSorted.get(j)){
                //lst.set(i+j,leftSorted.get(i));
                sortedArray.add(leftSorted.get(i));
                i++;
            }
            else {
//                lst.set(i+j,rightSorted.get(j));
                sortedArray.add(rightSorted.get(j));
                j++;
            }
        }
        while(i<=leftSorted.size()-1){

//                lst.set(i+j,leftSorted.get(i));
            sortedArray.add(leftSorted.get(i));
                i++;


        }
        while(j<=rightSorted.size()-1){

                sortedArray.add(rightSorted.get(j));
                j++;


        }
        return (List<Integer>)sortedArray;
    }
}
