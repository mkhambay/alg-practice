package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if(nums == null) {
            return -1;
        }

        if(nums.length == 0) {
            return 0;
        }

        int nonDupIndex = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[nonDupIndex]) {
                nonDupIndex++;
                nums[nonDupIndex] = nums[i];
            }
        }
        return nonDupIndex + 1; //since nonDupIndex starts at 0, length is always +1
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4};
        System.out.println("New Length = " + removeDuplicates(nums));
    }
}
