package Lambda;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass {
    
    public static void main(String[] args) {
        List<String> list = List.of("reyansh", "samay");
        Consumer<List<String>> consumer = (sList) -> {
            for(String s: sList) {
                System.out.println(s.toUpperCase());
            }
        };
        consumer.accept(list);
    }

}
