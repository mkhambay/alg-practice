package com.khambay.alg.strings;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }

        if(s1.length() != s2.length()) {
            return false;
        }

        return (s1+s1).indexOf(s2) != -1;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
