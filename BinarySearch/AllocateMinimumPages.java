package BinarySearch;

public class AllocateMinimumPages {
    
    public static void main(String[] args) {
        int[] a = {10, 10, 20, 30};
        System.out.println(allocateMinPages(a, 2));
    }

    public static int allocateMinPages(int[] a, int noOfStuds) {
        int min = findMax(a); // max pages read by one student (so give only 1 book with max).
        int max = findSum(a); // total number of pages to get the range.
        System.out.println("min: " + min  + " max: " + max);
        int res = 0;
        
        while(min <= max) {
            int mid = (min + max) / 2;
            if(isFeasible(a, noOfStuds, mid)) { 
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    public static boolean isFeasible(int[] a, int noOfStuds, int mid) {
        int student = 1, sum = 0;
        for(int i = 0; i < a.length; i++) {
            if(sum + a[i] > mid) {
                student++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return student <= noOfStuds;
    }

    public static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i]; 
            }
        }
         
        return max; 
    }

    public static int findSum(int[] a) {
        int sum = 0;
        for(int val: a) {
            sum += val;
        }
        return sum;
    }

}
