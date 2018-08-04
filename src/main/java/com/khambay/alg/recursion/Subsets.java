package com.khambay.alg.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time - O(nlogn) - sort
 * Space - O(n)
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class Subsets {

    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result , List<Integer> temp, int [] nums, int start) {
        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
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
