package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time - O(nlogn) - sort
 * Space - O(n)
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class Subset {

    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsetsRecursive(nums);

        for(List<Integer> a : subsets) {
            System.out.print("[ ");
            for(Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
