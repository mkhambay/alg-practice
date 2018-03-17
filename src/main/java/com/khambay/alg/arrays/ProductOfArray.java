package com.khambay.alg.arrays;

/**
 * Time and Space O(n)
 * Auxillary array Space - O(1)
 */
public class ProductOfArray {

    public static int[] productArray(int nums[]) {
        int temp;
        int n = nums.length;

        int result[] = new int[n];

        temp = 1;
        for (int i = 0; i < n; i++) {
            result[i] = temp;
            temp *= nums[i];
        }

        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        printArray(nums);
        int[] product = productArray(nums);
        printArray(product);
    }
}
