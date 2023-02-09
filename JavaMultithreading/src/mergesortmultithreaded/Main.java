package mergesortmultithreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(
                4,2,1,5,6,2,9,8,4,5
        );

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> sortedArray = executorService.submit(
                new Sorter(arrayToSort, executorService)
        ).get();

        for (int i : sortedArray) {
            System.out.println(i);
        }

        executorService.shutdown();

    }
}