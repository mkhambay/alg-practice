package com.khambay.alg.bit;

/**
 * Time - O(logn)
 */
public class HammingDistance {

    //Brian Kernighan’s Algorithm - https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
    public static int hammingDistance1(int x, int y) {
        int xor = x ^ y; //will give a count of how many differences 0 ^ 1 = 1 or 1 ^ 0 = 1
        int count = 0;

        while (xor != 0) { //will count the number of differences found in xor above - similar to NumberOfOneBits
            xor &= (xor - 1);  //if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the rightmost set bit
            count++;
        }
        return count;
    }

    public static int hammingDistance2(int x, int y) {
        int result = 0;
        int mask = 1;

        for(int i = 0; i < 32; i++) {
            if((x & mask) != (y & mask)) {
                result++;
            }

            mask <<= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hamming Distance2 1 4 = " + hammingDistance2(1,4));
        System.out.println("Hamming Distance1 1 4 = " + hammingDistance1(1,4));
    }
}
