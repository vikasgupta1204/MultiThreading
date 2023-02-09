package StartThreadWays;

public class LambdaStarter {

    public static void main(String[] args) {
        Runnable lambdaThread=()->{
            for(int i=0;i<10;i++) {
                System.out.println("hello world "+i+"  "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        System.out.println("main thread starts "+Thread.currentThread().getName());
        Thread t=new Thread(lambdaThread);
        t.start();

        Thread t1=new Thread(lambdaThread);
        t1.start();

        Thread t2=new Thread(lambdaThread);
        t2.start();
        System.out.println("main Thread ends "+Thread.currentThread().getName());
    }
}
