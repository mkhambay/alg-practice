package com.khambay.alg.bit;

/**
 * Time - O(n) ??
 * Space - O(1)
 */
public class GetSum {

    public static int getSumRecursive(int a, int b) {
        return (b == 0) ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }

    public static int getSum(int a, int b) {
        if(b == 0) {
            return a;
        }

        int sum,carry;

        sum = a ^ b;
        carry = (a & b) << 1;

        return getSum(sum,carry);
    }

    public static void main(String[] args) {
        System.out.println("Sum 1 + 2 = " + getSum(1, 2));
        System.out.println("Sum 1 + 2 = " + getSum(21, 9));
    }
}
