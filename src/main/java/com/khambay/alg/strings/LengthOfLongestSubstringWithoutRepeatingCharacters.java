package com.khambay.alg.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Time and Space - O(n)
 */
public class LengthOfLongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) { //found repeating char, reset i
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j + 1);
            result = Math.max(result, j + 1 - i); //substring - so + 1
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb = " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb = " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew = " + lengthOfLongestSubstring("pwwkew"));
    }
}
