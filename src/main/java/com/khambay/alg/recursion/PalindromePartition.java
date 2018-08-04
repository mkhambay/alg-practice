package com.khambay.alg.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Similar to Subsets problem
 * Time - O(n*(2^n))  isPalindrome is O(n)
 * Space - O(n)
 */
public class PalindromePartition {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(String s, int start, List<String> temp, List<List<String>> result){
        //base case
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
        }
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    temp.add(s.substring(start, i + 1));
                    backtrack(s, i + 1, temp, result);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String str, int l, int r) {
        while(l < r){
            if(str.charAt(l) != str.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> result = partition(input);
        System.out.println("Result = " + result);
    }
}
