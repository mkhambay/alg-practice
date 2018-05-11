package com.khambay.alg.strings;

/**
 * Time - O(n^2)
 * Space - O(n)
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= s.length(); j++) {
                if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
                    sb.append(count);
                    sb.append(s.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("4 = " + countAndSay(n));
    }
}
