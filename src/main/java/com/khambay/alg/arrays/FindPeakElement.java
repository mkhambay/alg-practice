package com.khambay.alg.arrays;

public class FindPeakElement {

    /**
     * Time - O(n)
     * Space - O(1)
     */
    public static int findPeakElement(int[] nums) {
        if(nums == null) {
            return -1;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] < nums[i]) {
                return i;
            }
        }

        //last element is the peak
        return nums.length - 1;
    }

    /**
     * Time and Space - O(log^2(n))
     */
    public static int findPeakElementBinarySearch(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int l, int r) {
        //Base case
        if (l == r)
            return l;

        int mid = (l + r) / 2;

        if (nums[mid] > nums[mid + 1]) { //search left
            return search(nums, l, mid);
        }
        else {
            return search(nums, mid + 1, r); //search right
        }
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,1};
        System.out.println("Peak Index = " + findPeakElement(nums));
        System.out.println("Peak - Binary Search - Index = " + findPeakElementBinarySearch(nums));
    }
}
