package SortingAlgorithms;

public class BubbleSort {
    
    public static void main(String[] args) {
        int[] a = {4, 3, 7, 1, 5};
        a = bubbleSortElements(a);
        for(int aEle: a) {
            System.out.print(aEle + " ");
        }
    }

    public static int[] bubbleSortElements(int[] a) {
        int n = a.length;
        for(int i = 0; i < n-1; i++) {
            /* Further optimization using swapped boolean variable.
            If swapping does not happens, then we know that the array is now already swapped.
            Hence, no need to iterate again. */
            boolean isSwapped = false;
            for(int j = 0; j < n-i-1; j++) {
                if(a[j+1] < a[j]) {
                    isSwapped = true;
                    swap(a, j+1, j);
                }
            }
            if(!isSwapped) break;
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
