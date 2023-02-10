package AdderSubTractorLocks;

import java.util.concurrent.locks.Lock;

public class Adder implements  Runnable{
    private Count count;
    Lock lock;
    Adder(Count count, Lock lock)

    {
        this.count=count;
        this.lock=lock;
    }

    public void run(){
        for(int i=1;i<=10000;i++){

            System.out.println(Thread.currentThread().getName()+"<-->"+i+"<-->"+count.value);
            lock.lock();
            count.addValue(i);
            lock.unlock();
        }
    }
}
