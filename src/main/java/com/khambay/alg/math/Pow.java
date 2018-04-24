package com.khambay.alg.math;

/**
 * Time - O(logn)
 * Space - O(1)
 */
public class Pow {

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * product;
            }
            product = product * product;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 power 2 = " + myPow(2, 2));
        System.out.println("2 power -2 = " + myPow(2, -2));
        System.out.println("2 power 8 = " + myPow(2, 8));
        System.out.println("5 power 2 = " + myPow(5, 2));
        System.out.println("5 power 3 = " + myPow(5, 3));
    }
}
