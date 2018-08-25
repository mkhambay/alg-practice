package com.khambay.alg.arrays;

/**
 * Like MaximumSubArray
 * Time - O(n)
 * Space - O(1)
 */
public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], maxProduct = nums[0];

        // we have to compare among max * A[i], min * A[i] as well as A[i],
        // since this is product, a negative * negative could be positive
        for (int i = 1; i < nums.length; i++) {
            int prevMax = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(prevMax * nums[i], min * nums[i]), nums[i]);

            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println("Max Product {2,3,-2,4} = " + maxProduct(nums));
        int[] nums1 = {-2,1,-4};
        System.out.println("Max Product {-2,1,-4} = " + maxProduct(nums1));
    }
}
