package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureFullExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1️⃣ Basic async task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Hello";
        });

        // 2️⃣ thenApply: transform the result
        CompletableFuture<String> transformedFuture = future.thenApply(s -> s + " World");

        // 3️⃣ thenAccept: consume the result
        transformedFuture.thenAccept(result -> System.out.println("thenAccept result: " + result));

        // 4️⃣ thenRun: run another task after completion
        transformedFuture.thenRun(() -> System.out.println("thenRun: Task completed"));

        // 5️⃣ thenCombine: combine results of two futures
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(500);
            return "Java";
        });

        CompletableFuture<String> combined = transformedFuture.thenCombine(future2, (res1, res2) -> res1 + " with " + res2);
        combined.thenAccept(result -> System.out.println("thenCombine result: " + result));

        // 6️⃣ allOf: wait for multiple futures
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> { sleep(700); return "F1"; });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> { sleep(800); return "F2"; });
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> { sleep(600); return "F3"; });

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
        all.thenRun(() -> System.out.println("allOf: All tasks completed"));

        // 7️⃣ exceptionally: handle exception
        CompletableFuture<String> exceptionFuture = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong");
            return "Success";
        }).exceptionally(ex -> "Handled: " + ex.getMessage());

        System.out.println("exceptionally result: " + exceptionFuture.get());

        // Wait for all async tasks to complete (optional)
        System.out.println(combined.get());
        System.out.println(all.get());
    }

    private static void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
