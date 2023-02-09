package MergeSortCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrToSort;
    private ExecutorService executor;
    Sorter(List<Integer> arrToSort,ExecutorService executorService){
        this.arrToSort=arrToSort;
        this.executor=executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrToSort.size()<=1){
            return arrToSort;
        }

        int mid=arrToSort.size()/2;
        List<Integer> leftArrayToSort=new ArrayList<>();
        for(int i=0;i<mid;++i){
            leftArrayToSort.add(arrToSort.get(i));
        }

        List<Integer> rightArrayToSort=new ArrayList<>();
        for(int i=mid;i<arrToSort.size();++i){
            rightArrayToSort.add(arrToSort.get(i));
        }


        Future<List<Integer>> sortLeftArrayFuture= executor.submit(new Sorter(leftArrayToSort,executor));
        Future<List<Integer>> sortRightArrayFuture=executor.submit(new Sorter(rightArrayToSort,executor));
        List<Integer> sortedArray=new ArrayList<>();

        List<Integer> sortedLeftArray=sortLeftArrayFuture.get();
        List<Integer> sortedRightArray=sortRightArrayFuture.get();
        int i=0;
        int j=0;
        while(i<sortedLeftArray.size()&&j<sortedRightArray.size()){
            if(sortedLeftArray.get(i)<sortedRightArray.get(j)){
                sortedArray.add(sortedLeftArray.get(i));
                i++;
            }
            else{
                sortedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        if(i<sortedLeftArray.size()){
            sortedArray.add(sortedLeftArray.get(i));
            i++;
        }
        if(j<sortedRightArray.size()){
            sortedArray.add(sortedRightArray.get(j));
            j++;
        }
            return sortedArray;
    }
}
