package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //move non zero value to nonZeroIndex
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        //starting at nonZeroIndex fill the rest with zeros.
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] arr1 = {0, 0, 1};
        moveZeroes(arr);
        System.out.println(arr);
    }
}
