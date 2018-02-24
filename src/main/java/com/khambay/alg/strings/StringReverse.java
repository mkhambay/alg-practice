package com.khambay.alg.strings;

public class StringReverse {

    public String reverse(String input) {
        char[] strArray = input.toCharArray();
        int left, right = 0;
        right = strArray.length-1;

        for (left=0; left < right ; left++,right--) {
            char temp = strArray[left];
            strArray[left] = strArray[right];
            strArray[right]=temp;
        }
        return new String(strArray);
    }

    public static void main(String args[]) {
        String reverseString = "John";

        StringReverse stringReverse = new StringReverse();
        System.out.println("Reversed string=" + stringReverse.reverse(reverseString));
    }
}
