package AdderSubTractorLocks;

import java.util.concurrent.locks.Lock;

public class Subtractor implements  Runnable{
    private Count count;
    Lock lock;
    Subtractor(Count count, Lock lock){
        this.lock=lock;
        this.count=count;
    }

    public void run(){
        for(int i=1;i<=10000;i++){
            System.out.println(Thread.currentThread().getName()+"<-->"+i+"<-->"+count.value);
            lock.lock();
            count.addValue(-i);
            lock.unlock();
        }
    }
}
