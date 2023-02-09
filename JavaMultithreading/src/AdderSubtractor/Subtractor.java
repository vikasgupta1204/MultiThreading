package AdderSubtractor;

public class Subtractor implements  Runnable{
    private Count count;
    Subtractor(Count count){
        this.count=count;
    }

    public void run(){
        for(int i=1;i<=10000;i++){
            System.out.println(Thread.currentThread().getName()+"<-->"+i+"<-->"+count.value);
            count.addValue(-i);
        }
    }
}
