package asyncTasks;

import java.util.concurrent.CompletableFuture;

public class AsyncT {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        })
                .thenApply((value) -> {
                    System.out.println(value);
                    return value;
    });
//        System.out.println("Result is: "+completableFuture.join());
        System.out.println("Result is: "+completableFuture);
    }
}
