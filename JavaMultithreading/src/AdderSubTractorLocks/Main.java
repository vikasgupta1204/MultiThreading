package AdderSubTractorLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Count c=new Count();
        Lock lock=new ReentrantLock(true);
        Thread t1=new Thread(new Adder(c,lock));
        t1.setName("Adder");
        Thread t2=new Thread(new Subtractor(c,lock));
        t2.setName("Subtractor");
        t1.start();
        t2.start();
       t1.join();
      t2.join();
        System.out.println(c.value);
    }
}
