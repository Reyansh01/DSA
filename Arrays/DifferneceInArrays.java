package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferneceInArrays {

    /*
     * Find the difference between two arrays: Two unsorted arrays are given, and
     * you need to find (arr1 – arr2) and (arr2 – arr1). The difference between the
     * two arrays is defined as all the elements from the first array which are not
     * present in the second array, taking the number of occurrences into
     * consideration. Example:
     * arr1: [3, 5, 2, 7, 4, 2, 7] arr2: [1, 7, 5, 2, 2, 9]
     * arr1 – arr2 = [3, 7, 4]
     * arr2 – arr1 = [1, 7]
     */

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 2, 7, 4, 2, 7};
        int[] arr2 = {9, 7, 5, 2, 2, 1};

        System.out.println(findDifference(arr1, arr2));
        System.out.println(findDifference(arr2, arr1));
    }
    
    private static List<Integer> findDifference(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for(int i = 0; i < n; i++) {
            freq1.put(arr1[i], freq1.getOrDefault(arr1[i], 0) + 1);
        }

        for(int i = 0; i < m; i++) {
            freq2.put(arr2[i], freq2.getOrDefault(arr2[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: freq1.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            int count2 = freq2.getOrDefault(entry.getKey(), 0);
            int remainingCount = count - count2;

            for(int i = 0; i < remainingCount; i++) {
                ans.add(element);
            }
        }
        return ans;
    }

}
