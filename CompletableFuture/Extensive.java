package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class Extensive {
    
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "My name is Reyansh ");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Reyansh").thenApply((name) -> learningClause(name));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() ->  { 
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "rey";
        }).thenApply((name) -> {
            System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return addFinalStatement(name);
        }).thenCompose((anotherFuture) -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return takeAnotherFuture(anotherFuture);
        });

        // thenApply and thenCompose are executed in the same thread which is the supplyAsync thread
        // thenApplyAsync and thenComposeAsync are executed in a new thread from the supplyAsync thread.

        System.out.println("Started every thread....");

        CompletableFuture<Void> allDone = CompletableFuture.allOf(future1, future2, future3);

        CompletableFuture<String> finalMessage = allDone.thenApply((function) -> {
            String msg1 = future1.join();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String msg2 = future2.join();
            String msg3 = future3.join();
            return msg1 + "\n" + msg2 + "\n" + msg3 + "\nAll futures completed successfully!";
        });
        System.out.println("Hererere");
        
        System.out.println(finalMessage.join());
    }

    private static String learningClause(String name) {
        return name + " is learning completableFuture extensively...";
    }

    private static CompletableFuture<String> takeAnotherFuture(String name) {
        return CompletableFuture.supplyAsync(() -> name);
    }

    private static String addFinalStatement(String anotherFuture) {
        return anotherFuture + " Everything seems good till this one..";
    }

}
