package Recursion;

public class WaysInMatrix {
    
    public static int findWaysInMatrix(int n, int m) {
        if(n == 1 || m == 1) return 1;
        return findWaysInMatrix(n - 1, m) + findWaysInMatrix(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(findWaysInMatrix(4, 3));
    }

}
