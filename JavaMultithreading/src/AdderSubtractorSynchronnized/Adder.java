package AdderSubtractorSynchronnized;

public class Adder implements  Runnable{
    private Count count;
    Adder(Count count){
        this.count=count;
    }

    public void run(){
        for(int i=1;i<=10000;i++){
            System.out.println(Thread.currentThread().getName()+"<-->"+i+"<-->"+count.value);
            synchronized (count) {
                count.addValue(i);
            }
        }
    }
}
