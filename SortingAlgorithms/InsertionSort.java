package SortingAlgorithms;

public class InsertionSort {
    
    public static void main(String[] args) {
        int[] a = {8, 4, 1, 5, 9, 2};
        a = insertionSortElemets(a);
        for(int aEle: a) {
            System.out.print(aEle + " ");
        }
    }

    public static int[] insertionSortElemets(int[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i-1;
            while(j >= 0 && a[j] > temp) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
        return a;
    }

}
