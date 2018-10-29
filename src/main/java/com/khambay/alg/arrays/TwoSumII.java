package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return new int[0];
        }

        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            }
            else if(sum > target) {
                right--;
            }
            else {
                left++;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] result = twoSum(nums, 9);

        System.out.print("[");
        for(int i : result) {
            System.out.print(i + ",");
        }
        System.out.println("]");
    }
}
