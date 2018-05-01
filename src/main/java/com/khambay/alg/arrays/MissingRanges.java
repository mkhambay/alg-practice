package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lo, int hi) {
        List<String> res = new ArrayList<>();

        //overflow check
        if(lo == Integer.MAX_VALUE) {
            return res;
        }

        // the next number we need to find
        int next = lo;

        for (int i = 0; i < nums.length; i++) {

            // not within the range yet
            if (nums[i] < next) {
                continue;
            }

            // continue to find the next one
            if (nums[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, nums[i] - 1));

            //overflow check
            if(nums[i] == Integer.MAX_VALUE) {
                return res;
            }

            // now we need to find the next number
            next = nums[i] + 1;
        }

        // do a final check
        if (next <= hi) {
            res.add(getRange(next, hi));
        }

        return res;
    }

    static String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 3, 50, 75};
//        List<String> missingRanges = findMissingRanges(nums, 0, 99);
//        System.out.println("Missing Ranges = " + missingRanges);

        int[] nums1 = {2147483647};
        List<String> missingRanges1 = findMissingRanges(nums1, 0, 2147483647);
        System.out.println("Missing Ranges 1 = " + missingRanges1);
    }
}
