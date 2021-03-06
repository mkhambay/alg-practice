package com.khambay.alg.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * Time - O(m+n)
 * Space - O(n)
 */
public class IntersectionOf2Arrays {

    public static int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }

        Set<Integer> result = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        //convert to array
        int[] resultArray = new int[result.size()];
        int i = 0;
        for(int num : result) {
            resultArray[i] = num;
            i++;
        }

        return resultArray;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersect(nums1, nums2);
        System.out.println("Result");
        printArray(result);
    }

}
