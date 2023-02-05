package print1to100;

public class NumberPrinter implements  Runnable{
    int numToPrint;
    NumberPrinter(int numToPrint){
        this.numToPrint=numToPrint;
    }

    public void run(){
        System.out.println(numToPrint+"<-->"+Thread.currentThread().getName());
    }
}
