package com.khambay.alg.strings;

public class StringReverse {

    public String reverseGeek(String input) {
        char[] temparray = input.toCharArray();
        int left, right=0;
        right = temparray.length-1;

        for (left=0; left < right ; left++ ,right--)
        {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right]=temp;
        }
        return new String(temparray);
    }

    public static void main(String args[]) {
        String reverseString = "John";

        StringReverse stringReverse = new StringReverse();
        System.out.println("Reversed stringGeek=" + stringReverse.reverseGeek(reverseString));
    }
}
