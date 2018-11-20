package com.khambay.alg.recursion;

/**
 * Time - O(n^2)
 * Space - O(1)
 */
public class PalindromicSubstrings {

    int count = 0;

    public int countSubstrings(String s) {
        count = 0;
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
            count++;
        }
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println("Input = abc Result = " + palindromicSubstrings.countSubstrings("abc"));
        System.out.println("Input = aaa Result = " + palindromicSubstrings.countSubstrings("aaa"));
    }
}
