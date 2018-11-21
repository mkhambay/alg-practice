package com.khambay.alg.strings;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int count = t.length(); // check whether the substring is valid
        int begin = 0, end = 0;//two pointers, one point to tail and one  head
        int len = Integer.MAX_VALUE; //the length of substring
        int start = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {  //keep extending end and also reducing its value in map
                count--; //when matching t found in s
            }

            while (count == 0) { //full match t in s found, its a while, not an if
                if (end - begin < len) {
                    len = end - begin;
                    start = begin;
                }

                if (map[s.charAt(begin++)]++ == 0) { //only matching t chars will be zero, rest will be negative
                    count++;
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";

        System.out.println("Result = " + minWindow(S, T));
    }
}
