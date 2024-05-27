package Recursion;

public class PermutationsOfString {
    
    public static void findPermutations(String s) {
        findPermutations(s, 0, s.length()-1);
    }

    public static void findPermutations(String s, int l, int r) {
        if(l == r) {
            System.out.println(s);
            return;
        }
        for(int i = l; i <= r; i++) {
            s = swapChars(s, l, i);
            findPermutations(s, l + 1, r);
            s = swapChars(s, l, i);
        }
    }

    public static String swapChars(String s, int l, int r) {
        char[] charArray = s.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;
        return new String(charArray);
    }

    public static void main(String[] args) {
        findPermutations("abc");
    }

}
