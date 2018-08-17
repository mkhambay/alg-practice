package com.khambay.alg.strings;

/**
 * Time and Space - O(n) - space could be less due to compression, worst case would be O(n) incase of no compression
 */
public class StringCompression {

    public String compressGabe(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            count++;

            if(i + 1 == str.length() //at the last character
                    || str.charAt(i) != str.charAt(i + 1) //peek ahead
            ) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String args[]) {
        StringCompression stringCompression = new StringCompression();
        String input1 = "aabcccccaaa";
        String input2= "abc";
        String input3 = "aabbcc";

        System.out.println("Input 1 =" + stringCompression.compressGabe(input1));
        System.out.println("Input 2 =" + stringCompression.compressGabe(input2));
        System.out.println("Input 3 =" + stringCompression.compressGabe(input3));
    }
}
