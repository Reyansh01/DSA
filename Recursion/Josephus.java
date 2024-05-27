package Recursion;

public class Josephus {
    
    public static int josephusWinner(int n, int k) {
        if(n == 1) return 0;
        return (josephusWinner(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println(josephusWinner(5, 3));
    }

}
