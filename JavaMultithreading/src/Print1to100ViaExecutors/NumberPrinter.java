package Print1to100ViaExecutors;

public class NumberPrinter implements  Runnable{
    int num;
    NumberPrinter(int num){
        this.num=num;
    }
    public void run(){
        System.out.println("Number is "+num+" <-->"+Thread.currentThread().getName());
    }
}
