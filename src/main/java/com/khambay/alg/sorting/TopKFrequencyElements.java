package com.khambay.alg.sorting;

import java.util.*;

/**
 * Bucket Sort
 * Time and Space - O(n)
 */
public class TopKFrequencyElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        //Array Index - Frequency
        //Array Value - List of Integers with that frequency
        List<Integer>[] bucket = new List[nums.length + 1]; // +1 to match frequency number as java starts from 0

        //Key - Integer
        //Value - Frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for(Integer n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for(Integer key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        //Starts at the end of the array where frequency is highest
        for(int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
            if (bucket[pos] != null) {
                result.addAll(bucket[pos]); //Adds all Integers with that frequency ex. 1, 5
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        List<Integer> result = topKFrequent(nums, 2);
        System.out.println("Result = " + result);

        int[] nums1 = {1,1,1,2,2,3,5,5,5};
        List<Integer> result1 = topKFrequent(nums1, 2);
        System.out.println("Result1 = " + result1);
    }
}
