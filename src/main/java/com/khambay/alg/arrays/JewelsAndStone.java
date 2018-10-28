package com.khambay.alg.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Time - O(J+S)
 * Space - O(J)
 */
public class JewelsAndStone {

    public static int numJewelsInStones(String J, String S) {
        if(J == null || J.length() < 1 || S == null || S.length() < 1) {
            return 0;
        }

        int result = 0;

        Set<Character> chars = new HashSet<>();
        for(char c : J.toCharArray()) {
            if(!chars.contains(c)) {
                chars.add(c);
            }
        }

        for(char d : S.toCharArray()) {
            if(chars.contains(d)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println("Result = " + numJewelsInStones(J, S));
    }
}
