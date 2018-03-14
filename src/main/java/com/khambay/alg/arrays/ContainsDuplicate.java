package com.khambay.alg.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Time and Space - O(n)
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);

        for(int i : nums) {
            if(numSet.contains(i)) {
                return true;
            }
            numSet.add(i);
        }
        return false;
    }

    //Efficient - Time - O(nlogn) Space - O(1)
    public static boolean containsDuplicateWithSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5,5,3};
        System.out.println("Contains Duplicate = " + containsDuplicate(nums));

        int[] nums1 = {1,4,5,3};
        System.out.println("Contains Duplicate = " + containsDuplicate(nums1));

        int[] nums2 = {1,4,5,5,3};
        System.out.println("Contains Duplicate = " + containsDuplicateWithSort(nums2));
    }
}
