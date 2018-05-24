package com.khambay.alg.recursion;

/**
 * Time - O(n^2)
 * Space - O(1)
 */
public class LongestPalindromicSubstring {

    private static int startIndex, maxLength;

    public static String longestPalindrome(String s) {
        int strLength = s.length();

        if (strLength < 2) {
            return s;
        }

        for (int i = 0; i < strLength - 1; i++) { //note - strLength - 1 as we have i + 1 on Line 20
            extendPalindrome(s, i, i); //odd
            extendPalindrome(s, i, i + 1); //even ex. bb
        }

        return s.substring(startIndex, startIndex + maxLength + 1); //+1 as String substring method does endIndex - 1
    }

    private static void extendPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        //reset begin and end to before end of while loop
        begin++;
        end--;

        int newLength = end - begin;

        if (newLength > maxLength) {
            maxLength = newLength;
            startIndex = begin;
        }
    }

    public static void main(String[] args) {
//        System.out.println("abb = " + longestPalindrome("abb"));
        System.out.println("Longest Palindromic Substring = " + longestPalindrome("babad"));
    }
}
