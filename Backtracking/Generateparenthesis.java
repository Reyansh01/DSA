package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Generateparenthesis {
    
    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        List<String> list2 = new ArrayList<>();
        generateParenthesisBacktrack(list2, n, "", 0, 0);

        for(String s: list) {
            System.out.println(s);
        }
        System.out.println("Done via permutation and valid parenthesis.... Now, it's time for Backtracking.......");
        for(String s: list2) {
            System.out.println(s);
        }
    }

    /* backtrack once we reach 'n' as we will have only 'n' number of '(' brackets
    once we reach the open parenthesis uptill 'n' 
    then start appending ')' parenthesis to create a full string */
    private static void generateParenthesisBacktrack(List<String> ans, int n, String currString, int openPar, int closePar) {
        if(currString.length() == n * 2) {
            ans.add(currString);
        }

        if(openPar < n) generateParenthesisBacktrack(ans, n, currString + "(", openPar + 1, closePar);
        if(closePar < openPar) generateParenthesisBacktrack(ans, n, currString + ")", openPar, closePar + 1);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder paren = new StringBuilder();
        for(int i = 0; i < n; i++) {
            paren.append("()");
        }
        
        // find all permutations
        Set<String> perm = findAllPermutations(paren.toString());
        Set<String> perm1 = perm.stream().filter(s -> s.startsWith("(")).filter(s -> s.endsWith(")")).collect(Collectors.toSet());
        // for(String s: perm1) {
        //     System.out.println(s);
        // }

        // valid parenthesis
        for(String s: perm1) {
            int[] stack = new int[s.length()];
            int top = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(') {
                    stack[top] = s.charAt(i);
                    top++;
                } else {
                    if(top == 0) {
                        top = -1;
                        break;
                    }
                    if(s.charAt(i) == ')') {
                        top--;
                    } else {
                        break;
                    }
                }
            }
            if(top == 0) ans.add(s);
        }

        // for(String s: perm1) {
        //     Stack<Character> stack = new Stack<>();
        //     for(int i = 0; i < s.length(); i++) {
        //         if(s.charAt(i) == '(') {
        //             stack.push(s.charAt(i));
        //         } else {
        //             if(!stack.isEmpty() && s.charAt(i) == ')') {
        //                 stack.pop();
        //             } else {
        //                 stack.push(')');
        //                 break;
        //             }
        //         }
        //     }
        //     if(stack.empty()) ans.add(s);
        // }

        return ans;
    }

    private static Set<String> findAllPermutations(String s) {
        Set<String> perms = new HashSet<>();
        return findPermutations(s, 0, s.length() - 1, perms);
    }

    private static Set<String> findPermutations(String s, int l, int r, Set<String> perms) {
        if(l == r) {
            perms.add(s);
        }

        for(int i = l; i <= r; i++) {
            s = swapChars(s, l, i);
            findPermutations(s, l + 1, r, perms);
            s = swapChars(s, l, i);
        }
        return perms;
    }

    private static String swapChars(String s, int l, int r) {
        char[] charArr = s.toCharArray();
        char temp = charArr[l];
        charArr[l] = charArr[r];
        charArr[r] = temp;
        return new String(charArr);
    }

}
