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
        String first = strs[0];

        for(int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);

            //compare to each char of remaining strings
            for(int j = 1; j < strs.length; j++) {
                String str = strs[j];

                //as soon as the chars don't match, return the substring of first string
                if(i == str.length() //the strings could be smaller in size than first
                        || str.charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }

        //all matched the first string entirely
        return first;
    }

    public static void main(String[] args) {
        String[] strs = {"leets", "leetcode", "leet", "leeds"};
        System.out.println("Longest Common Prefix = " + longestCommonPrefix(strs));
    }
}
