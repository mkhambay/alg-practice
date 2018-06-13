package com.khambay.alg.bit;

/**
 * Time O(n)
 * Space O(1)
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result += n & 1;    // apply 1s mask gets the bit set either 0 & 1 = 0 or 1 & 1 = 1
            n >>>= 1;           // do unsigned shift to right by 1

            if (i < 31) {         // for last digit, don't shift
                result <<= 1;   // shift result left by 1
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("43261596 = " + reverseBits(43261596));
    }
}
