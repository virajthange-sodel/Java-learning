package multithreading.deadlock;

public class Monster {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {

//        one synchronized inside another synchronized means same thread is holding lock1 and, while still holding it, is trying to acquire lock2.
        Thread thread1 = new Thread(() -> {
           synchronized (lock1) {
               System.out.println("Thread1 got the lock1");
               try {
                   Thread.sleep(4000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Thread1 is trying to get lock2 after one second");
               synchronized (lock2) {
                    System.out.println("Thread1 got the lock2");
               }
               System.out.println("Thread1 finishes the execution");
           }
        });

//        To avoid the deadlock, we have to follow the same order to acquire locks
        Thread thread2 = new Thread(() -> {
           synchronized (lock2) {
               System.out.println("Thread2 got the lock2");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Thread2 is trying to get lock1");
               synchronized (lock1) {
                    System.out.println("Thread2 got the lock1");
               }
           }

//            we don't need to manually unlock anything.
//            synchronized (lock1) {
//                System.out.println("Thread2 got the lock1");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("Thread2 is trying to get lock2");
//                synchronized (lock2) {
//                    System.out.println("Thread2 got the lock2");
//                }
//                System.out.println("Thread2 finishes the execution");
//            }
        });
        thread1.start();
        thread2.start();
    }
}
