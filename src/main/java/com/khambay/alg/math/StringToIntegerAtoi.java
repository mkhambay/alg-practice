package com.khambay.alg.math;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        int index = 0, sign = 1, result = 0;
        //1. Empty string
        if(str.length() == 0) {
            return 0;
        }

        //2. Remove Spaces
        while(str.charAt(index) == ' ') {
            if(index == str.length() - 1) { //edge case when String is just empty " "
                return 0;
            }
            index++;
        }

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()) {
            int digit = str.charAt(index) - '0';

            if(digit < 0 || digit > 9) { //check if valid number
                break;
            }

            //check if total will be overflow after 10 times and add digit
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE %10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println("42 = " + myAtoi("42"));
        System.out.println("   -42 = " + myAtoi("   -42"));
        System.out.println("4193 with words = " + myAtoi("4193 with words"));
        System.out.println("words and 987 = " + myAtoi("words and 987"));
        System.out.println("-91283472332 = " + myAtoi("-91283472332"));
        System.out.println("  = " + myAtoi(" "));
    }
}
