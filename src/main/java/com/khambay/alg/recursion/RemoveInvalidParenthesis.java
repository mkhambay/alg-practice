package com.khambay.alg.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Time - O(n^2) ??
 * Space - O(n)
 */
public class RemoveInvalidParenthesis {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    public static void remove(String s, List<String> result, int iStart, int jStart,  char[] par) {
        int stack = 0;

        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) {
                continue; //matches and the return below is never reached if all matched up fine
            }

            for (int j = jStart; j <= i; j++) { //when mis-match found
                if (s.charAt(j) == par[1]
                        && (j == jStart || s.charAt(j - 1) != s.charAt(j))) //not duplicate
                    remove(s.substring(0, j) //removes char at j
                            + s.substring(j + 1, s.length()), result, i, j, par);
            }

            return; //once all processing is done
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, result, 0, 0, new char[]{')', '('});
        else // finished right to left
            result.add(reversed);
    }

    public static void main(String[] args) {
        System.out.println("Input = ()())()  Result = " + removeInvalidParentheses("()())()"));
        System.out.println("Input = (a)())()  Result = " + removeInvalidParentheses("(a)())()"));
    }
}
