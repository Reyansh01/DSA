package DP;

public class Fibinacci {
    
    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibonacciBrute(n)); // Time -> O(2^n), Space -> O(n)

        int[] dp = new int[n + 1];
        // Arrays.fill(dp, 0);
        // dp[0] = 0;
        // dp[1] = 1;
        System.out.println(fibonacciDP(n, dp)); // Time -> O(n), Space -> O(n)

        System.out.println(fibonacciOptimized(n)); // Time -> O(n), Space -> O(1)
    }

    private static int fibonacciBrute(int n) {
        if(n <= 1) {
            return n;
        }

        return fibonacciBrute(n - 1) + fibonacciBrute(n - 2);
    }

    private static int fibonacciDP(int n, int[] dp) {
        if(n <= 1) {
            return n;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibonacciBrute(n - 1) + fibonacciBrute(n - 2);
    }

    private static int fibonacciOptimized(int n) {
        if(n <= 1) {
            return n;
        }

        int prev1 = 0, prev2 = 1;

        for(int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

}
