package com.khambay.alg.recursion;

import java.util.Arrays;

/**
 * Dynamic Programming - Binary Search
 * Time - O(nlogn) - Binary search takes log(n) and is called n times
 * Space - O(n) - dp array size of n
 *
 * Arrays.binarySearch() method returns index of the search key, if it is contained in the array,
 * else it returns -(insertion point) - 1. The insertion point is the point at which the key
 * would be inserted into the array: the index of the first element greater than the key,
 * or -(toIndex) - 1 if all elements in the array are less than the specified key
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) { //element not found, returns index of -(insertion) - 1 or -(len) - 1
                i = -(i + 1); //if not found, binary search returns index as negative and with - 1. This step adds that back.
            }

            dp[i] = num;

            if (i == len) { //increment length when we find a new value to insert to dp
                len++;
            }
        }
        return len; //this is the length of LIS
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LongestIncreasingSubsequence = " + lengthOfLIS(nums));
    }
}
