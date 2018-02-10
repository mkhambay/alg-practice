package com.khambay.alg.strings;

import java.util.Arrays;

public class StringPermutation {

    public boolean isPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;

        boolean found = false;
        int count = 0;

        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j< b.length(); j++){
                if(a.charAt(i) == b.charAt(j)) {
                    found = true;
                    count++;
                    break;
                }
            }
        }

        if(count != a.length()) {
            found = false;
        }
        return found;
    }

    private String sort(String s) {
        char[] stringArray = s.toCharArray();
        Arrays.sort(stringArray);
        return new String(stringArray);
    }

    public boolean isPermutationGabeSorting(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        return sort(a).equals(sort(b));
    }

    public boolean isPermutationGabeCharacterCounts(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();

        for(char c: s_array) {
            letters[c]++;
        }

        for(int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if(letters[c] < 0) {
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
