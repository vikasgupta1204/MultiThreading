package print1to100;

import java.util.NavigableMap;

public class Main {
    public static void main(String[] args) {

        for(int i=1;i<=100;i++){
            NumberPrinter np=new NumberPrinter(i);
            Thread t=new Thread(np);

            if(i==99){
                continue;
            }
            t.start();


        }
    }
}
