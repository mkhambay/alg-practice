package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time - O(nlogn) - sort
 * Space - O(n)
 */
public class Subset {

    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null) {
            return null;
        }

        //Sort the array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            //Create a temp list to capture previous results
            //and add the current element to each of them
            List<List<Integer>> temp = new ArrayList<>();

            //Get all the prior results and add them new to temp
            for(List<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }

            //Add current element to each in temp
            for(List<Integer> t : temp) {
                t.add(nums[i]);
            }

            //Add the current element in a new list
            List<Integer> currentNum = new ArrayList<>();
            currentNum.add(nums[i]);
            temp.add(currentNum);

            //put all of new temp in result
            result.addAll(temp);
        }

        //Add an empty set
        List<Integer> emptySet = new ArrayList<>();
        result.add(emptySet);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);

        for(List<Integer> a : subsets) {
            System.out.print("[ ");
            for(Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
