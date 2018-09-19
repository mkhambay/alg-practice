package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time - O(n^2) - 3 pointers i, j, k
 * Sort it first
 * Space - O(n)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 3)
            return result;

        //Need to sort ascending for processing duplicates
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) { //with j and k pointers - 2 for i

            if(i == 0 // first iteration
                    || nums[i] != nums[i - 1] //not duplicate - not same as prev
                    ) {
                int j = i + 1;
                int k = nums.length - 1;

                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if(sum == 0) {  //found result
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        result.add(triplets);

                        j++;
                        k--;

                        //handle duplicate - if the new j or k values are same as the prev value just processed
                        while(j < k && nums[j] == nums[j - 1])
                            j++;

                        while(j < k && nums[k] == nums[k + 1])
                            k--;

                    }
                    else if(sum < 0) { //array is sorted. If total <0, we need to move j up to next higher value
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
