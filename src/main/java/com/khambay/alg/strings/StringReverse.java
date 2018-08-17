package com.khambay.alg.strings;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class StringReverse {

    public String reverse(String input) {
        char[] strArray = input.toCharArray(); //String is immutable, have to convert to char array and recreate back
        int left = 0, right = strArray.length-1;

        while(left < right) {
            char temp = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = temp;
            left++;
            right--;
        }
        return new String(strArray);
    }

    public static void main(String args[]) {
        String reverseString = "John";

        StringReverse stringReverse = new StringReverse();
        System.out.println("Reversed string=" + stringReverse.reverse(reverseString));
    }
}
