package com.khambay.alg.strings;

/**
 * Time - O(S) - S is the sum of all characters in all strings.
 * best case there are at most n*minLenn comparisons where
 * minLen is the length of the shortest string in the array
 *
 * Space - O(1)
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        //Vertical scanning

        //loop through first string each character
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            //compare to each char of remaining strings
            for(int j = 1; j < strs.length; j++) {

                //as soon as the chars don't match, return the substring of first string
                if(i == strs[j].length() //always check if strs length, boundry check
                        || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        //all matched the first string entirely
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"leets", "leetcode", "leet", "leeds"};
        System.out.println("Longest Common Prefix = " + longestCommonPrefix(strs));
    }
}
