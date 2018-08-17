package com.khambay.alg.strings;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class StringUnique {

    public boolean isUniqueGabeOn(String str) {
        if(str.length() > 128)
            return false;

        boolean[] chars = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(chars[c]) {
                return false;
            }
            chars[c] = true;
        }
        return true;
    }

    public static void main(String args[]){
        StringUnique stringUnique = new StringUnique();
        String testNotUnique = "hutg9mnd!nk9";
        String testUnique = "abcd10jk";

        if(stringUnique.isUniqueGabeOn(testNotUnique))
            System.out.println("isUnique for " + testNotUnique + " failed");

        if(!stringUnique.isUniqueGabeOn(testUnique))
            System.out.println("isUnique for " + testUnique + " failed");

        System.out.println("charAt 0 =" + testUnique.charAt(0));
        int val = testUnique.charAt(0);
        System.out.println("int ascii value charAt 0 =" + val);

    }
}
