package Mathematics;

import java.util.Arrays;

public class SeiveOfEratosThenes {
    
    public static boolean[] calculateSeiveOfEratosThenes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] = true) { // optimization
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        boolean[] isPrime = calculateSeiveOfEratosThenes(20);
        for(int i = 0; i <= 20; i++) {
            System.out.println(i+ " " + isPrime[i]);
        }
    }

}