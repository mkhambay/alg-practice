package com.khambay.alg.sorting;

import java.util.Arrays;

/**
 * Time - O(nklognk)
 * - the length of input array is n
 * - average length of Strings in s_num is k
 * - compare 2 strings will take O(k)
 * - Sorting will take O(nlogn)
 * - Appending to StringBuilder takes O(n)
 * - O(k nlogn k) + O(n)
 */
public class LargestNumber {

    public static String largestNumber(int[] num) {
        if(num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for(int i = 0; i < num.length; i++) {
            s_num[i] = String.valueOf(num[i]);
        }

        //Concatenates s1 to s2 and the reverse to see which is bigger
        //ex. 3 + 30 or 30 + 3 => 330
        //    330 + 34 or 34 + 330 => 34330
        //    34330 + 5 or 5 + 34330 => 534330
        //    534330 + 9 or 9 + 534330 => 9534330
        Arrays.sort(s_num, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0') {
            return "0";
        }

        //Result
        StringBuilder sb = new StringBuilder();
        for(String s: s_num) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10,2};
        System.out.println("{10,2} Result = " + largestNumber(nums));
        int[] nums1 = {3,30,34,5,9};
        System.out.println("{3,30,34,5,9} Result = " + largestNumber(nums1));
    }
}
