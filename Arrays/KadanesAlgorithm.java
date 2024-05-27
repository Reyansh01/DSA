package Arrays;

import java.util.Arrays;

public class KadanesAlgorithm {
    
    public static void main(String[] args) {
        int[] arr = {-5, 4, 6, -3, 4, -1};
        // int[] arr = {5, -4, -2, 6, -1};
        System.out.println(printMaximumSumFromSubarray(arr));
        int[] subArray = printMaximumSumSubarray(arr);
        System.out.print("{ ");
        for(int i = 0; i < subArray.length; i++) {
            System.out.print(subArray[i]);
            if (i < subArray.length - 1) {
                System.out.print(" ,");
            }
        }
        System.out.println("}");
    }

    public static int printMaximumSumFromSubarray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static int[] printMaximumSumSubarray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
                endIndex = i+1;
            }
            if(currSum < 0) {
                currSum = 0;
                startIndex = i+1;
            }
        }
        return Arrays.copyOfRange(arr, startIndex, endIndex);
    }

}
