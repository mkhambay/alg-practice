package com.khambay.alg.strings;

import java.util.Arrays;

public class StringPermutation {

    //Time - O(nlogn) - Arrays.sort
    //Space - O(1)
    public boolean isPermutationGabeSorting(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        return sort(a).equals(sort(b));
    }

    private String sort(String s) {
        char[] stringArray = s.toCharArray();
        Arrays.sort(stringArray);
        return new String(stringArray);
    }

    //Time - O(n)
    //Space - O(1)
    public boolean isPermutationGabeCharacterCounts(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[128];

        for(char c: s.toCharArray()) {
            chars[c]++;
        }

        for(char d: t.toCharArray()) {
            chars[d]--;
            if(chars[d] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args) {
        StringPermutation stringPermutation = new StringPermutation();
        String aPerm = "sumit";
        String bPerm = "tiums";
        String aNotPerm = "abcd";
        String bNotPerm = "bdea";
        String aNotPerm1 = "abcde";
        String bNotPerm1 = "ab";

        if(!stringPermutation.isPermutationGabeCharacterCounts(aPerm, bPerm)) {
            System.out.println("Failed for" + aPerm + " " + bNotPerm);
        }

        if(stringPermutation.isPermutationGabeCharacterCounts(aNotPerm, bNotPerm)) {
            System.out.println("Failed for" + aNotPerm + " " + bNotPerm);
        }

        if(stringPermutation.isPermutationGabeCharacterCounts(aNotPerm1, bNotPerm1)) {
            System.out.println("Failed for" + aNotPerm1 + " " + bNotPerm1);
        }
    }
}
