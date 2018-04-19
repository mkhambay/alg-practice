package com.khambay.alg.sorting;

import java.util.Arrays;

public class ValidAnagram {

    /**
     * Sorting
     * Time - O(nlogn) - Arrays.sort
     * Space - O(1)
     */
    public static boolean isAnagramOnLogn(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * Hashtable
     * Time - O(n)
     * Space - O(1)
     */
    public static boolean isAnagramOn(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is Anagram isAnagramOn =" + isAnagramOn(s, t));
        System.out.println("Is Anagram isAnagramOnLogn =" + isAnagramOnLogn(s, t));

        String s1 = "rat";
        String t1 = "car";
        System.out.println("Is Anagram isAnagramOn =" + isAnagramOn(s1, t1));
        System.out.println("Is Anagram isAnagramOnLogn =" + isAnagramOnLogn(s1, t1));

    }
}
