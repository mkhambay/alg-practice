package com.khambay.alg.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }

    public static void generateParenthesis(List<String> result, String curr, int open, int close, int n) {
        //base case - if we have reached string length 6, we have one result
        if(curr.length() == n * 2) {
            result.add(curr);
            return;
        }

        if(open < n) { //left - go to max n to kick off the pairs
            generateParenthesis(result, curr + "(", open + 1, close, n);
        }
        if(close < open) { //right - we have more open brackets, we need to close
            generateParenthesis(result, curr + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        List<String> parentheses = generateParenthesis(3);
        for(String s : parentheses) {
            System.out.println(s);
        }
    }
}
