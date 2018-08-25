package com.khambay.alg.arrays;

/**
 * First Missing Smallest Positive Integer - includes sorting by putting the value in the right index
 * value in num == index of num + 1
 * Time - O(n)
 * Space - O(1)
 */
public class FirstMissingPositiveInteger {

    public static int firstMissingPositive(int[] nums) {
        int i = 0;

        //sort and put the number in its correct index
        while (i < nums.length) {
            if (nums[i] == i + 1 //value matches index + 1
                    || nums[i] <= 0  //we are only looking for positive numbers
                    || nums[i] > nums.length) { //value out of index match range
                i++;
            }
            else if (nums[i] != nums[nums[i] - 1]) { //put the number in its correct index
                swap(nums, i, nums[i] - 1);
            }
            else {
                i++;
            }
        }

        //find the missing number = index + 1
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }

        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println("Missing Number {1,2,0} = " + firstMissingPositive(nums));

        int[] nums1 = {3,4,-1,1};
        System.out.println("Missing Number {3,4,-1,1} = " + firstMissingPositive(nums1));

        int[] nums2 = {7,8,9,11,12};
        System.out.println("Missing Number {7,8,9,11,12} = " + firstMissingPositive(nums2));

    }
}
