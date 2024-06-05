package SortingAlgorithms;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] a = {4, 6, 2, 5, 7, 9, 1, 3};
        a = quickSortElements(a, 0, a.length - 1);
        for(int aEle: a) {
            System.out.print(aEle + " ");
        }
    }

    public static int[] quickSortElements(int[] a, int l, int h) {
        if(l < h) {
            int pivot = partition(a, l, h);
            System.out.println(pivot + " " + a[pivot]);
            quickSortElements(a, l, pivot-1);
            quickSortElements(a, pivot+1, h);
        }
        return a;
    }

    public static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l;
        int j = h;
        
        while(i < j) {
            while(a[i] <= pivot) i++;
            while(a[j] > pivot) j--;
            if(i < j) swap(a, i, j);
        }
        swap(a, j, l);
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

}
