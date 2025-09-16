package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable worker = () -> {
            System.out.println("start of the thread" + Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
                System.out.println("End of thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };


        new Thread(worker, "T1").start();
        new Thread(worker, "T2").start();
        new Thread(worker, "T3").start();


    }
}
