package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length; // mod is important - even if k = 10, its really 3 steps

        //reverse entire array
        reverse(nums, 0, nums.length - 1);

        //reverse start to k - 1
        reverse(nums, 0, k - 1);

        //reverse k to end of array
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        printArray(nums);
        rotate(nums, 10);
        printArray(nums);
    }
}
