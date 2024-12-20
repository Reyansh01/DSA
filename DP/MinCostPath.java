package DP;

import java.util.ArrayList;
import java.util.List;

public class MinCostPath {
    
    public static void main(String[] args) {

        // can iterate left, right, down and diagonal.
        List<List<Integer>> cost = new ArrayList<>();
        cost.add(new ArrayList<>(List.of(1, 2, 3)));
        cost.add(new ArrayList<>(List.of(4, 8, 2)));
        cost.add(new ArrayList<>(List.of(1, 5, 3)));

        System.out.println(minCostPathRecursive(cost));
        System.out.println(minCostPathDP(cost));
        System.out.println(minCostPath1DDP(cost));
    }

    // RECURSIVE SOLUTION (Time -> O(3^(m+n)), Space -> O (m+n)) :::
    private static int minCostPathRecursive(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        int ans = 0;
        // ans = minCostPathRecursiveHelper(cost, m - 1, n - 1);
        ans = minCostPathRecursiveHelper(cost, m - 1, n - 1, 0, 0);
        return ans;
    }

    // top-down recursion
    private static int minCostPathRecursiveHelper(List<List<Integer>> cost, int m, int n) {
        // base cases
        if(m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if(m == 0 && n == 0) {
            return cost.get(m).get(n);
        }

        /* m - 1 = same column (top), n - 1 = same row (left), m - 1 and n - 1 = diagonal upper left because,
        in the question it is given that we can only traverse down, right and diagonally lower cells.
        So, if i'm at a current cell i must have come from either top, left or diagonally upper left cell.
        */
        return cost.get(m).get(n) + Math.min(Math.min(minCostPathRecursiveHelper(cost, m - 1, n), minCostPathRecursiveHelper(cost, m, n - 1)), minCostPathRecursiveHelper(cost, m - 1, n - 1));
    }

    private static int minCostPathRecursiveHelper(List<List<Integer>> cost, int m, int n, int row, int col) {
        // base cases
        if(row > m || col > n) {
            return Integer.MAX_VALUE;
        }
        if(row == m && col == n) {
            return cost.get(row).get(col);
        }

        /* m + 1 = same column (down), n + 1 = same row (right), m + 1 and n + 1 = diagonal lower right because,
        in the question it is given that we can only traverse down, right and diagonally lower cells.
        So, if i want to traverse from the current cell then i can go either down, right or diagonally lower right cell.
        */
        return cost.get(row).get(col) + Math.min(Math.min(minCostPathRecursiveHelper(cost, m, n, row + 1, col), minCostPathRecursiveHelper(cost, m, n, row, col + 1)), minCostPathRecursiveHelper(cost, m, n, row + 1, col + 1));
    }



    // DP SOLUTION (Time -> O(m*n), Space -> O(m*n)) :::
    private static int minCostPathDP(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return minCostPathDPHelper(cost, m - 1, n - 1, 0, 0, dp);
    }

    private static int minCostPathDPHelper(List<List<Integer>> cost, int m, int n, int row, int col, int[][] dp) {
        // base cases
        if (row > m || col > n) {
            return Integer.MAX_VALUE;
        }
        if (row == m && col == n) {
            return cost.get(row).get(col);
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = cost.get(row).get(col) + Math.min(Math.min(minCostPathDPHelper(cost, m, n, row + 1, col, dp), minCostPathDPHelper(cost, m, n, row, col + 1, dp)), minCostPathDPHelper(cost, m, n, row + 1, col + 1, dp));

        return dp[row][col];
    }


    // MOST OPTIMIZED DP SOLUTION (1-D DP) (Time -> O(m*n), Space -> O(n)) :::
    private static int minCostPath1DDP(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        int[] dp = new int[n];

        // to get to 0, 0 we will require cost.get(0).get(0) cost.
        dp[0] = cost.get(0).get(0);

        // fill dp based on first row.
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + cost.get(0).get(i);
        }

        // fill the next rows
        for(int i = 1; i < m; i++) {
            // store prev value to calculate next values (diagonal top-left cell)
            int prev = dp[0];

            // fill based on first column
            dp[0] = dp[0] + cost.get(i).get(0);

            for(int j = 1; j < n; j++) {
                int temp = dp[j];
                
                // dp[j - 1] here means left cell and dp[j] means the top cell above it
                dp[j] = cost.get(i).get(j) + Math.min(dp[j], Math.min(dp[j - 1], prev));
                prev = temp;
            }
        }

        return dp[n - 1];
    }

}
