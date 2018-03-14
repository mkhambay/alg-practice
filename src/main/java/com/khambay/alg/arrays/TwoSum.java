package com.khambay.alg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Time and Space O(n)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        if(nums == null || nums.length < 2) {
            throw new IllegalArgumentException("No two sum solution");
        }

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)
                    && map.get(complement) != i //you may not use the same element twice
                    ) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] pairs = twoSum(nums, target);
        System.out.println("Pairs index = [" + pairs[0] + "," + pairs[1] + "]");
    }
}
