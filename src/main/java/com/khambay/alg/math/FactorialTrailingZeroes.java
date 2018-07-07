package com.khambay.alg.math;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52432/3-lines-of-Java-O(logn)-time-O(1)-space
 *
 * Time - O(5 base logn) ?
 * Space - O(1)
 */
public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int zeros = 0;

        while (n > 4) { //zeros start only when n is > 4 - see below
            zeros += (n/=5);  //diving by 5 gives the number of zeros in it, ex 5/5 = 1, 10/5 = 2 zeros - see below
        }

        return zeros;
    }

    public static void main(String[] args) {
        System.out.println("5! = " + trailingZeroes(5));
        System.out.println("10! = " + trailingZeroes(10));
        System.out.println("200! = " + trailingZeroes(200));
    }
}

/*
n	n!
0	1
1	1
2	2
3	6
4	24 --> zero start after 4
5	120
6	720
7	5040
8	40320
9	362880
10	3628800
 */