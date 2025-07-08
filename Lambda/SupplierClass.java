package Lambda;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierClass {
    
    public static void main(String[] args) {
        Supplier<Integer> supplier = () ->  new Random().nextInt(100);
        System.out.println(supplier.get());
    }

}
