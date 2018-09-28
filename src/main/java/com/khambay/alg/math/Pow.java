package com.khambay.alg.math;

/**
 * Time - O(logn)
 * Space - O(1)
 */
public class Pow {

    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;  //have to divide the number in half if power is negative
            n = -n;     //switch negative power to positive for calculation
        }
        double result = 1;
        double product = x;

        for (int pow = n; pow > 0; pow /= 2) {
            if ((pow % 2) == 1) { //if power is odd ex. 3 or it started with 4 and each time dividing by 2 will leave 1
                result = result * product; //result is multiplied for odd powers, ex pow 3
            }
            product = product * product;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("2 power 2 = " + myPow(2, 2));
        System.out.println("2 power 2 = " + myPow(2, 2));
        System.out.println("2 power -2 = " + myPow(2, -2));
        System.out.println("2 power 8 = " + myPow(2, 8));
        System.out.println("5 power 2 = " + myPow(5, 2));
        System.out.println("5 power 3 = " + myPow(5, 3));
        System.out.println("5 power 5 = " + myPow(5, 5));
    }
}
