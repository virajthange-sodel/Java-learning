package completableFuture;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Complete {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        System.out.println("Friends");

        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
//                System.out.println("Inside completableFuture " + Thread.currentThread().getName());
                    for (int i = 0; i < 50; i++) {
                        try {
                            System.out.println(" " + Thread.currentThread().getName());
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return "Adarsh";
                }
        )
                .thenApply((value) -> {
                    return value + " completed";
                });
        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Inside completableFuture 2" + Thread.currentThread().getName());
                    for (int i = 0; i < 50; i++) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return "Ram";
                }
        )
                .thenApply((value) -> {
                    return value + " completed";
                });

        completableFuture.get();
        completableFuture2.get();

        String join =(String) completableFuture.join();
        String join2 =(String) completableFuture2.join();

        System.out.println(join);
        System.out.println(join2);
    }
}
