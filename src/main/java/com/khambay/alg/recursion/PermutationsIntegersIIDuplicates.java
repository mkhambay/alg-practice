package com.khambay.alg.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * Time - O(n!)
 * Space - O(n)
 */
public class PermutationsIntegersIIDuplicates {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        //base case
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || //just like the contains check for non dups case
                        i > 0 && nums[i] == nums[i-1] && !used[i-1] //dups check - also make sure previous used is false - if previous used is true, this dup is part of that permutation and let it go through
                        ) {
                    continue; // element already exists, skip
                }
                used[i] = true;
                temp.add(nums[i]);
                backtrack(result, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result = permute(nums);
        System.out.println("Result = " + result);
    }
}
