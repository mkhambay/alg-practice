package com.khambay.alg.math;

/**
 * Time and Space - O(n) ?
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            int newResult = result * 10 + lastDigit;

            //Integer overflow check - function returns 0 when the reversed integer overflows
            if ((newResult - lastDigit) / 10 != result) {
                return 0;
            }

            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Reverse 123 = " + reverse(123));
        System.out.println("Reverse -123 = " + reverse(-123));
    }
}
