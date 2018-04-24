package com.khambay.alg.math;

/**
 * Time - O(log base 3 to the power of n) log3n
 * Space - 1
 */
public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n = n/3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println("2 = " + isPowerOfThree(2));
        System.out.println("18 = " + isPowerOfThree(18));
        System.out.println("3 = " + isPowerOfThree(3));
        System.out.println("9 = " + isPowerOfThree(9));
        System.out.println("27 = " + isPowerOfThree(27));
        System.out.println("28 = " + isPowerOfThree(28));
    }
}
