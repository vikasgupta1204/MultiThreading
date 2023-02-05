package printhelloworld;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world by  "+Thread.currentThread().getName());


        PrintHelloWorld phw=new PrintHelloWorld();
        Thread t=new Thread(phw);

        t.start();


        Thread t1=new Thread(phw);
        t1.start();
        Thread t2=new Thread(phw);
        t2.start();

        System.out.println("Hello world is called by last line "+Thread.currentThread().getName());
    }
}
