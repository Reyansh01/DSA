package Lambda;

import java.util.Optional;

public class OptionalClass {
    
    public static void main(String[] args) {
        
        String name = null;
        Optional<String> optional = Optional.ofNullable(name);
        String greet = optional.map(op -> "Hello " + op + " !!").orElse("Hello anonymous !!");
        System.out.println(greet);
        // consumer, runnable.....
        optional.ifPresentOrElse((s) -> System.out.println(s), () -> System.out.println("Hello anonymous !!"));
        
    }

}
