package com.khambay.alg.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    //Time and Space O(n)
    public static int missingNumberHashSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }

        for(int number = 0; number <= nums.length; number++) { // <= and not <
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    //Time - O(nlogn) and Space O(1)
    public static int missingNumber(int[] nums) {
        if(nums == null) {
            return -1;
        }

        //sort it
        Arrays.sort(nums);

        //the missing number is between the first and last elements
        //the number should match its index
        for(int i = 0; i <= nums.length; i++) {

            //Last number is not the length of the array
            if(i == nums.length-1 && nums[i] != nums.length) {
                return nums.length;
            }

            if(nums[i] != i) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println("Missing number {9,6,4,2,3,5,7,0,1} = " + missingNumber(nums));
        System.out.println("Missing number Hashset = " + missingNumberHashSet(nums));

        int[] nums1 = {0};
        System.out.println("Missing number {0} = " + missingNumber(nums1));
        System.out.println("Missing number Hashset = " + missingNumberHashSet(nums1));

        int[] nums2 = {0,1};
        System.out.println("Missing number {0,1} = " + missingNumber(nums2));
        System.out.println("Missing number Hashset = " + missingNumberHashSet(nums2));

        int[] nums3 = {1};
        System.out.println("Missing number {1} = " + missingNumber(nums3));
        System.out.println("Missing number Hashset = " + missingNumberHashSet(nums3));
    }

}
