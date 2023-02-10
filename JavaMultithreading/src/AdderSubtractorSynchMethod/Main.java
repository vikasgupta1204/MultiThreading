package AdderSubtractorSynchMethod;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Count c=new Count();
        Thread t1=new Thread(new Adder(c));
        t1.setName("Adder");
        Thread t2=new Thread(new Subtractor(c));
        t2.setName("Subtractor");
        t1.start();
        t2.start();
       t1.join();
      t2.join();
        System.out.println(c.value);
    }
}
