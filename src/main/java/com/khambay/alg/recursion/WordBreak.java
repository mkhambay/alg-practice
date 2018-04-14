package com.khambay.alg.recursion;

import java.util.*;

/**
 * Dynamic Programming - Bottom up with memoization
 * Time - O(n^2)
 * Space - O(n)
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict); //prevents dups

        //memo
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true; //need this set for initial match

        //substring function endIndex is used as endIndex - 1 in the String implementation
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (memo[start] && wordDictSet.contains(s.substring(start, end))) {
                    memo[end] = true;  //we test with memo[start], but set memo[end]
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] words = {"leet", "code"};
        List<String> wordDict = Arrays.asList(words);

        System.out.println("Word Break = " + wordBreak(s, wordDict));
    }
}
