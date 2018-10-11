package com.khambay.alg.math;

/**
 * https://leetcode.com/problems/base-7/description/
 *
 * Time - O(n)
 * Space - O(1)
 */
public class Base7 {

    public static String base7(int num) {
        if(num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        String sign = num < 0 ? "-" : "";

        while(num != 0) {
            int lastDigit = Math.abs(num % 7); //without Math.abs lastDigit could be negative and end up with -1-1
            sb.insert(0, lastDigit);
            num /= 7;

            if(num == 0) {
                sb.insert(0, sign);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println("Base 7 of " + num + " = " + base7(num));

        int num1 = -7;
        System.out.println("Base 7 of " + num1 + " = " + base7(num1));

        int num2 = -8;
        System.out.println("Base 7 of " + num2 + " = " + base7(num2));

    }
}
