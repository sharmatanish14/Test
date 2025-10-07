package multithreading;

public class DeadlockExample {

    public static void main(String[] args) {
        Object resource1 = "Resource1";
        Object resource2 = "Resource2";

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                System.out.println("Thread 1: Waiting for resource 2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                System.out.println("Thread 2: Waiting for resource 1...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
