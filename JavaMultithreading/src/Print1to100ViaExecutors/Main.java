package Print1to100ViaExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService=Executors.newFixedThreadPool(10);
        for(int i=0;i<=100;i++) {
            executorService.execute(new NumberPrinter(i));
            if(i==51){
                System.out.println("abcd");
                continue;
            }
        }
    }
}
