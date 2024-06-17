package Hashing;

import java.util.Map;
import java.util.HashMap;

public class subArraySum {
    
    public static void main(String[] args) {
        int[] a = {10, 15, -5, 15, -10, 5};
        int sum = 5;
        sumSubArray(a, sum);
    }

    public static void sumSubArray(int[] a, int sum) {
        int len = a.length;
        int curr_sum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < len; i++) {
            curr_sum += a[i];

            // suppose sum = 20 then this special case works.
            if(curr_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            
            if(hm.containsKey(curr_sum - sum)) {
                start = hm.get(curr_sum - sum) + 1;
                end = i;
                break;
            }
            hm.put(curr_sum, i);
        }

        if(end == -1) {
            System.out.println("No value present");
        } else {
            System.out.println("start: " + start + " end: " + end);
        }
    }

}
