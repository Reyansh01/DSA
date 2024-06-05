package SortingAlgorithms;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] a = {9, 4, 7, 6, 3, 1, 5};
        a = mergeSortElements(a, 0, a.length - 1);
        for(int aEle: a) {
            System.out.print(aEle + " ");
        }
    }

    public static int[] mergeSortElements(int[] a, int l, int r) {
        if(l <  r) {
            int mid = (l+r)/2;
            mergeSortElements(a, l, mid);
            mergeSortElements(a, mid+1, r);
            a = merge(a, l, mid, r);
        }
        return a;
    }

    public static int[] merge(int[] a, int l, int mid, int r) {
        int[] b = new int[a.length];
        int i = l;
        int j = mid+1;
        int k = l;
        while(i <= mid && j <= r) {
            if(a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if(i > mid) {
            while(j <= r) {
                b[k] = a[j];
                j++;
                k++;
            }
        } else {
            while(i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }
        for(k = l; k <= r; k++) {
            a[k] = b[k];
        }
        return a;
    }

}
