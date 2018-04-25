package com.khambay.alg.math;

import java.util.HashMap;

/**
 * Time - O(n)?
 * Space - O(n)?
 */
public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        if (numerator < 0 ^ denominator < 0) { //XOR if either is negative, but not both
            res.append("-");
        }

        // Convert to Long or else abs(-2147483648) overflows
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);

        //The remainder could be zero while doing the division.
        // That means there is no repeating fractional part and you should stop right away.
        // 2 % 2 -> remainder is 0 or 2 % 1 -> 0
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");

        //maps from the remainder to its position of the fractional part
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) { //repeating fractional part
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("numerator = 1, denominator = 2 Result = " + fractionToDecimal(1, 2));
        System.out.println("numerator = 2, denominator = 1 Result = " + fractionToDecimal(2, 1));
        System.out.println("numerator = 2, denominator = 3 Result = " + fractionToDecimal(2, 3));
        System.out.println("numerator = -2, denominator = 3 Result = " + fractionToDecimal(-2, 3));
        System.out.println("numerator = 4, denominator = 333 Result = " + fractionToDecimal(4, 333));
        System.out.println("numerator = -22, denominator = -2 Result = " + fractionToDecimal(-22, -2));
    }
}
