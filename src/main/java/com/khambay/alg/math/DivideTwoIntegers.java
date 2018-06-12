package com.khambay.alg.math;

/**
 * https://leetcode.com/problems/divide-two-integers/discuss/13407/Detailed-Explained-8ms-C++-solution
 *
 * Time - O(n^2) ?
 * Space - O(1)
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || //divide by zero
                dividend == Integer.MIN_VALUE && divisor == -1 //overflow check
                ) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if (dividend < 0 ^ divisor < 0) { //XOR if either is negative, but not both
            sign = -1;
        }

        // Convert to Long or else abs(-2147483648) overflows
        long num = Math.abs((long)dividend);
        long den = Math.abs((long)divisor);

        int result = 0;

        while (num >= den) {
            long denCopy = den;
            long multiple = 1;

            while (num >= denCopy << 1) {
                denCopy <<= 1; // << is multiply by 2
                multiple <<= 1;
            }

            num -= denCopy; //ex 15 - 12
            result += multiple; //ex 4, then 1
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println("dividend = 15, divisor = 3  Output = " + divide(15, 3));
        System.out.println("dividend = 7, divisor = -3  Output = " + divide(7, -3));
    }
}
