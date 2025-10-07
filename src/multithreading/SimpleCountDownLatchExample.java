package multithreading;

import java.util.concurrent.CountDownLatch;

public class SimpleCountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2); // Wait for 2 threads

        Thread worker1 = new Thread(() -> {
            System.out.println("Worker 1 is working...");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("Worker 1 finished.");
            latch.countDown(); // Decrease count by 1
        });

        Thread worker2 = new Thread(() -> {
            System.out.println("Worker 2 is working...");
            try { Thread.sleep(1500); } catch (InterruptedException e) {}
            System.out.println("Worker 2 finished.");
            latch.countDown(); // Decrease count by 1
        });

        worker1.start();
        worker2.start();

        System.out.println("Main thread waiting...");
        latch.await(); // Wait until count = 0
        System.out.println("All workers finished. Main thread continuing...");
    }
}
