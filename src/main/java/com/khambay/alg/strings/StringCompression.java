package com.khambay.alg.strings;

public class StringCompression {

    public String compressString(String str) {
        if(str == null || str.length() < 2) {
            return str;
        }

        StringBuilder buf = new StringBuilder();
        char curr = str.charAt(0);
        char prev = curr;
        int count = 1;

        for(int i = 1; i < str.length(); i++) {
            curr = str.charAt(i);

            if (curr == prev) {
                count++;
            } else {
                buf.append(prev);
                buf.append(count);
                prev = curr;
                count = 1;
            }
        }
        //tail
        buf.append(prev);
        buf.append(count);

        return buf.length() < str.length() ? buf.toString() : str;
    }

    public String compressGabe(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if(i + 1 >= str.length() //check for tail
                    || str.charAt(i) != str.charAt(i + 1) //peek ahead
            ) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
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
