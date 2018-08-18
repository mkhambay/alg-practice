package com.khambay.alg.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Time and Space - O(n)
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) { //found repeating char, reset i
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j + 1 - i); //substring - so + 1
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb = " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb = " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew = " + lengthOfLongestSubstring("pwwkew"));
    }
}
