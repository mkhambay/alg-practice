package com.khambay.alg.bit;


/**
 * Time and Space - O(1)
 */
public class NumberOfOneBits {

    public static int hammingWeight(int n) {
        int result = 0;
        int mask = 1;

        for(int i = 0; i < 32; i++) {
            if((n & mask) != 0) { //apply 1s mask and use & operator. 1 & 1 = 1, bit is set
                result++;
            }
            mask <<= 1; //shift 1s bit to 1 left and keep doing it for all 32 bits
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("11 = " + hammingWeight(11));
    }
}
