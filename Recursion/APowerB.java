package Recursion;

public class APowerB {
    
    public static long calulatePower(long a, long b) {
        if(b == 0) return 1;
        return calulatePower(a, b - 1) * a;
    }

    public static void main(String[] args) {
        System.out.println(calulatePower(2, 8));
    }

}
