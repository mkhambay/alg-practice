package com.khambay.alg.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Time - O(nlogn)
 * Space - O(1)
 */
public class MajorityElement {

    /*
        If the elements are sorted in monotonically increasing (or decreasing) order,
        the majority element can be found at index n/2 if n is odd and n/2 + 1 if n is even. */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //////// Time and Space O(n)

    public static int majorityElementMap(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    ////////

    public static void main(String[] args) {
        int[] nums = {2,1,2,5,2,2,4,2,6,3};
        System.out.println("Majority Element Sort = " + majorityElement(nums));

        System.out.println("Majority Element Map = " + majorityElementMap(nums));
    }
}
