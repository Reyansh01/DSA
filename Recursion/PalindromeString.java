package Recursion;

public class PalindromeString {
    
    public static boolean isPalindrome(String s, int l, int r) {
        if(l >= r) return true;
        if(s.charAt(l) != s.charAt(r)) return false;
        return isPalindrome(s, l + 1, r - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba", 0, "abcba".length() - 1));
    }

}
