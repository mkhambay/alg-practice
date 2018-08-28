package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length < 1) {
            return true;
        }

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};

        System.out.println("Can Jump {2,3,1,1,4} = " + canJump(nums));
        System.out.println("Can Jump {3,2,1,0,4} = " + canJump(nums1));
    }
}
