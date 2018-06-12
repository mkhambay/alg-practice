package com.khambay.alg.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Time - O(n^2) ?
 * Space - O(n)
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();

        int squareSum = 0;
        int lastDigit = 0;

        while (nums.add(n)) { //add to set to prevent infinite loop
            squareSum = 0;

            while (n > 0) {
                lastDigit = n % 10;
                squareSum += lastDigit * lastDigit;
                n /= 10;
            }

            if (squareSum == 1) {
                return true;
            }
            else {
                n = squareSum;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Is 19 Happy ? = " + isHappy(19));
        System.out.println("Is 18 Happy ? = " + isHappy(18));
    }
}
