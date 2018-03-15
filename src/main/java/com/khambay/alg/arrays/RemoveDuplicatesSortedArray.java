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

        int slow = 0;

        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("New Length = " + removeDuplicates(nums));
    }
}
