package Recursion;

public class StringSubsequence {
    
    public static void findSubsequences(String s) {
        findSubsequences(s, 0, "");
    }

    public static void findSubsequences(String s, int i, String currString) {
        if(i == s.length()) {
            System.out.println(currString);
            return;
        }
        findSubsequences(s, i + 1, currString + s.charAt(i)); // include a.
        findSubsequences(s, i + 1, currString); // do not include.
    }

    public static void main(String[] args) {
        findSubsequences("abc");
    }

}
