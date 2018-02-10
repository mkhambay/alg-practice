package com.khambay.alg.strings;

public class StringUnique {

    public boolean isUniqueOn2(String str) {
        for (int i=0; i<str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public boolean isUniqueGabeOn(String str) {
        if(str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int valAscii = str.charAt(i);
            if(char_set[valAscii]) {
                return false;
            }
            char_set[valAscii] = true;
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
