package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class Greeting {
    
    public static void main(String[] args) {
        
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Reyansh").thenApply((name) -> fetchGreeting(name)).thenCompose((composeGreet) -> fetchStatement(composeGreet));
        System.out.println(completableFuture.join());

    }

    private static CompletableFuture<String> fetchStatement(String greet) {
        return CompletableFuture.supplyAsync(() -> greet);
    }

    private static String fetchGreeting(String name) {
        return "Hello " + name + "! How are you?? ";
    }

}
