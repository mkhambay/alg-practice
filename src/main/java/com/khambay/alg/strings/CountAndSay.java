package com.khambay.alg.strings;

/**
 * Similar to String Compression - count goes first
 * Time - O(n^2)
 * Space - O(n)
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            s = compress(s);
        }
        return s;
    }

    private static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            count++;

            if(i + 1 == str.length() //at the last character
                    || str.charAt(i) != str.charAt(i + 1) //peek ahead
                    ) {
                compressed.append(count); //count goes first
                compressed.append(str.charAt(i));
                count = 0;
            }
        }
        return compressed.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("4 = " + countAndSay(n));
    }
}
