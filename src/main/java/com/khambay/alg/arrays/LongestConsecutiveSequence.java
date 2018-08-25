package com.khambay.alg.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Time and Space O(n)
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>(); //to allow O(1) lookups
        for (int num : nums) {
            numsSet.add(num);
        }

        int maxLength = 0;

        for (int num : numsSet) {
            if (!numsSet.contains(num-1)) {
                int currentNum = num;
                int length = 1;

                while (numsSet.contains(currentNum+1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("longestConsecutive = " + longestConsecutive(nums));
    }
}
