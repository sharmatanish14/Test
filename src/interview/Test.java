package interview;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable run = ()->{
            System.out.println(Thread.currentThread().getName() + " started execution");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " ended execution");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };


        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();

        System.out.println("Main method execution finished");
    }
}
