package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Time and Space - O(n)
 */
public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lo, int hi) {
        List<String> result = new ArrayList<>();

        // the next number we need to find
        int next = lo;

        for (int i = 0; i < nums.length; i++) {

            // not within the range yet
            if (nums[i] < next) {
                continue;
            }

            //overflow check
            if(next == Integer.MAX_VALUE) {
                return result;
            }

            // continue to find the next one
            if (nums[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            result.add(getRange(next, nums[i] - 1));

            //overflow check
            if(nums[i] == Integer.MAX_VALUE) {
                return result;
            }

            // now we need to find the next number
            next = nums[i] + 1;
        }

        // do a final check
        if (next <= hi) {
            result.add(getRange(next, hi));
        }

        return result;
    }

    static String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        List<String> missingRanges = findMissingRanges(nums, 0, 99);
        System.out.println("Missing Ranges = " + missingRanges);

        int[] nums1 = {2147483647};
        List<String> missingRanges1 = findMissingRanges(nums1, 0, 2147483647);
        System.out.println("Missing Ranges 1 = " + missingRanges1);

        int[] nums2 = {1,1,1};
        List<String> missingRanges2 = findMissingRanges(nums2, 1, 1);
        System.out.println("Missing Ranges 2 = " + missingRanges2);
    }
}
