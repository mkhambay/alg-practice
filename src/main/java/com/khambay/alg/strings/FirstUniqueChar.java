package com.khambay.alg.strings;

import java.util.LinkedHashMap;

/**
 * Time and Space - O(n)
 */
public class FirstUniqueChar {

    public static int firstUniqChar(String s) {
        int freq [] = new int[26];

        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for(int i = 0; i < s.length(); i++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        String test = new String("dddccdbba");
        System.out.println("First unique char 1 = " + firstUniqChar(test));

        String test1 = new String("leetcode");
        System.out.println("First unique char 1 = " + firstUniqChar(test1));
    }
}
