package multithreading.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockEx {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                if (lock.tryLock(6, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread1 got the lcok");
                        System.out.println("Lock is : " + lock);
                        Thread.sleep(4000);
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Thread1 coould not get the lock");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thead1 finished the execution !");
            }

        });


        Thread thread2 = new Thread(() -> {
            if (lock.tryLock()) {
                System.out.println("Thread2 got the lcok");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                    System.out.println("Thread2 released the lock");
                }
            } else {
                System.out.println("Thread2 coould not get the lock");
            }
        });

        thread1.start();
        thread2.start();
    }
}
