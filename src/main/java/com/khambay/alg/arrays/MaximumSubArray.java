package com.khambay.alg.arrays;


/**
 * Time - O(n)
 * Space - O(1)
 */
public class MaximumSubArray {

    public static int getMaxSumGabe(int[] a) {
        int maxSum = 0;
        int runningSum = 0;
        for (int i = 0; i < a.length; i++) {
            runningSum += a[i];
            if (maxSum < runningSum) {
                maxSum = runningSum;
            } else if (runningSum < 0) {
                runningSum = 0;
            }
        }
        return maxSum;
    }

    public static int maxSubArrayLeetCode(int[] nums) {
        if(nums == null) {
            return -1;
        }

        int runningSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            runningSum = Math.max(runningSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSumGabe(a));
        System.out.println(maxSubArrayLeetCode(a));

        int[] b = {-2,-1};
        System.out.println(maxSubArrayLeetCode(b));
    }
}
