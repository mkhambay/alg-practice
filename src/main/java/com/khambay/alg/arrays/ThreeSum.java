package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time - O(n^2)
 * Space - O(n)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) { //with j and k pointers - 2 for i

            if(i == 0 // first iteration
                    || nums[i] > nums[i - 1] //only if numbers are ascending
                    ) {
                int j = i + 1;
                int k = nums.length - 1;

                while(j < k) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j < k && nums[j] == nums[j - 1])
                            j++;

                        while(j < k && nums[k] == nums[k + 1])
                            k--;

                    }
                    else if(nums[i] + nums[j] + nums[k] < 0) { //array is sorted. If total <0, we need to move j up to next higher value
                        j++;
                    }
                    else { //array is sorted ascending. k-- as total is already greater than 0. We need to get closer to 0.
                        k--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSums = threeSum(nums);

        for(List<Integer> sums : threeSums) {
            System.out.print("[ ");
            for(Integer i : sums) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
