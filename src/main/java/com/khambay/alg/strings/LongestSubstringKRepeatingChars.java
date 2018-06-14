package com.khambay.alg.strings;

/**
 * Time - O(n^2)
 * Space - O(n)
 */
public class LongestSubstringKRepeatingChars {

    public static int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str,0,s.length(),k);
    }

    private static int helper(char[] str, int start, int end,  int k){
        //base case - length shorter than k
        if (end - start < k) {
            return 0;
        }

        //build frequency table
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i] - 'a']++;
        }

        //find char that does not meet the k freq requirement. ex. aaabb and k = 3, it is b
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] < k) { //chars that are less than k and don't meet the requirement
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k); //this will chop off from begin to start of the char that does not match k requirement. ex. 0-3 in case of aaa
                        int right = helper(str, j+1, end, k); //this will chop from 4-5 incase of aaabb example
                        return Math.max(left, right); //return the max length - 3 incase of aaabb
                    }
                }
            }
        }

        //If every character in this substring occurs at least k times, ex. aaa
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println("aaabb and k = 3 Result = " + longestSubstring("aaabb", 3));
        System.out.println("ababbc and k = 2 Result = " + longestSubstring("ababbc", 2));
    }
}
