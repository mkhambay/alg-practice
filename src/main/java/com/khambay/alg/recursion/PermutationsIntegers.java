package com.khambay.alg.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * Time - O(n!)
 * Space - O(n)?
 */
public class PermutationsIntegers {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        //base case
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) {
                    continue; // element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println("Result = " + result);
    }
}
