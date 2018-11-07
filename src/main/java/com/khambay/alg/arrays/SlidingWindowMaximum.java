package com.khambay.alg.arrays;

/**
 * Time - O(n)
 */
public class SlidingWindowMaximum {

    public static int[] slidingWindowMax(int[] nums, final int k) {
        if(nums == null || nums.length < 1) {
            return new int[0];
        }

        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for (int i = 1, j = n - 1 - 1; i < n; i++, j--) {
            leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i - 1], nums[i]); //mod for partition
            rightMax[j] = (j % k == 0) ? nums[j] : Math.max(rightMax[j + 1], nums[j]); //mod for partition
        }

        int[] slidingMax = new int[n - k + 1];
        for (int i = 0; i + k <= n; i++) {
            slidingMax[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }

        return slidingMax;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,6,3,8,9,10,12,56};
        int k = 4;
        int[] result = slidingWindowMax(nums, k);

        System.out.print("Input {2,1,3,4,6,3,8,9,10,12,56} Result = [");
        for(int i : result) {
            System.out.print(i + ",");
        }
        System.out.println("]");

        int[] nums1 = {9,10,9,-7,-4,-8,2,-6};
        int k1 = 5;
        int[] result1 = slidingWindowMax(nums1, k1);

        System.out.print("Input {9,10,9,-7,-4,-8,2,-6} Result = [");
        for(int i : result1) {
            System.out.print(i + ",");
        }
        System.out.println("]");
    }
}
