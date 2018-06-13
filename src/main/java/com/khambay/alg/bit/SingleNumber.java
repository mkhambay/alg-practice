package com.khambay.alg.bit;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println("Result = " + singleNumber(nums));

        int[] nums1 = {4,1,2,1,2};
        System.out.println("Result = " + singleNumber(nums1));
    }

    /*
    If we take XOR of zero and some bit, it will return that bit
        a ^ 0  = a
    If we take XOR of two same bits, it will return 0
        a ^ a = 0

    a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b

     */
}
