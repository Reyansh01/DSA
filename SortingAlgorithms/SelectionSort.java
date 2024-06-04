package SortingAlgorithms;

public class SelectionSort {
    
    public static void main(String[] args) {
        int[] a = {4, 1, 9, 2, 3, 6};
        a = selectionSortElements(a);
        for(int aEle: a) {
            System.out.print(aEle + " ");
        }
    }

    public static int[] selectionSortElements(int[] a) {
        int n = a.length;
        for(int i = 0; i < n-1; i++) {
            int min = i;
            for(int j = i+1; j < n; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            if(min != i) {
                swap(a, min, i);
            }
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
