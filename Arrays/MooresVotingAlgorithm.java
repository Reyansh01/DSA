package Arrays;

public class MooresVotingAlgorithm {
    
    public static void main (String[] args) {
        int[] arr = {5, 1, 4, 1, 1};
        System.out.println(printMajorityElement(arr));
    }

    public static int printMajorityElement(int[] arr) {
        int finalIndex = 0;
        int finalCount = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[finalIndex]) {
                finalCount++;
            } else {
                finalCount--;
            }
            if(finalCount == 0) {
                finalIndex = i;
                finalCount = 0;
            }
        }

        finalCount = 0;
        int potentialAnsElement = arr[finalIndex];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == potentialAnsElement) {
                finalCount++;
            }
        }

        return finalCount > arr.length/2 ? arr[finalIndex] : -1;

    }

}
