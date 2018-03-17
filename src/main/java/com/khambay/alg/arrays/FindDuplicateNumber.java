package com.khambay.alg.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Time - O(n)
 * Space - extra aux - O(1)
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        //Put numbers in HashSet
        Set<Integer> numsSet = new HashSet<>();

        //Check if contains while adding
        for(int i = 0; i < nums.length; i++) {
            if(numsSet.contains(nums[i])) {
                return nums[i];
            }
            else {
                numsSet.add(nums[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println("Duplicate number is " + findDuplicate(nums));
    }
}
