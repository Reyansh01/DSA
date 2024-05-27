package Mathematics;

public class Power {
    
    public static long calculatePower(long n, long power, long modulo) {
        long res = 1;
        while(power > 0) {
            if((power & 1) != 0) { // power & 1 gives us odd or even by checking last significant bit.
                // res = (res * n % modulo) % modulo; this is same as below as it will never overflow the modulo.
                res = (res % modulo * n % modulo) % modulo;
            }
            n = (n % modulo * n % modulo) % modulo;
            power = power >> 1; // right shift operator divides a number by 2.
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(3978432, 5, 1000000007)); // 10^9 + 7 as modulo
    }

}
