package com.khambay.alg.math;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;

            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            }

            result = result * 10 + digit;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Reverse 123 = " + reverse(123));
        System.out.println("Reverse -123 = " + reverse(-123));
    }
}
