package com.khambay.alg.arrays;


/**
 * Time - O(n)
 * Space - O(n)
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if(digits == null) {
            return new int[0];
        }

        int carry = 0;

        for(int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];

            //add 1 for ones digit
            if(i == digits.length - 1) { //add 1 to last digit to start the plus one process
                digit = digit + carry + 1;
            }
            else {
                digit = digit + carry;
            }

            //if value >= 10, set carry
            if(digit >= 10) {
                digits[i] = digit % 10; /* Get second digit */
                carry = 1;
            }
            else {
                digits[i] = digit;
                carry = 0;
            }
        }

        //If the addition has outgrown the array, we need to add it to begining of the array
        //Create a new array by copying digits over and add 1 as first digit
        if(carry == 1){
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        else {
            return digits;
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] digits = {1,0,9};
        printArray(digits);
        int[] digitsAdded = plusOne(digits);
        printArray(digitsAdded);

        int[] digits1 = {9,9,9};
        printArray(digits1);
        int[] digitsAdded1 = plusOne(digits1);
        printArray(digitsAdded1);
    }
}
