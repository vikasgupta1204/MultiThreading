package printhelloworld;

public class PrintHelloWorld implements  Runnable{
    public void run(){
        System.out.println("Print Hello World by "+Thread.currentThread().getName());
    }
}
