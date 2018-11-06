package com.khambay.alg.bit;

import java.util.LinkedList;
import java.util.List;

/**
 * https://en.wikipedia.org/wiki/Gray_code
 *
 * 1 << n - Gray coding the least significant bit follows a repetitive pattern of 2 on,
 * 2 off ( … 11001100 … ); the next digit a pattern of 4 on, 4 off; and so forth.
 *
 * These codes are also known as single-distance codes, reflecting the Hamming distance of 1 between adjacent codes
 */
public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);  //G(i) = i ^ (i/2)
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.println("Gray Code 2 = " + grayCode(2));
    }

    /*
    Decimal	Binary	Gray
0	0000	0000
1	0001	0001
2	0010	0011
3	0011	0010
     */
}
