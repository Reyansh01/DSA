package Misc;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateElementsUsingStream {
    
    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 1, 4, 2, 5, 8, 3);
        List<Integer> remDup = l.stream().filter(i -> !(Collections.frequency(l, i) > 1)).collect(Collectors.toList());
        System.out.println(remDup);
    }

}
