package com.khambay.alg.search;

/**
 * Time and Space - O(log^2(n))
 */
public class FindPeakElement {

    public static int findPeakElementBinarySearch(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    //note - in this binary search, the nums list is not ordered
    public static int search(int[] nums, int low, int high) {
        //Base case
        if (low == high)
            return low; //found the peak

        int mid = (low + high) / 2;

        if (nums[mid] > nums[mid + 1]) { //search left as the right side is sloping down
            return search(nums, low, mid); // note - we don't do mid - 1 as in regular binary search, with this low == high
        }
        else {
            return search(nums, mid + 1, high); //search right
        }
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,1};
        System.out.println("Peak Index = " + findPeakElementBinarySearch(nums));
        System.out.println("Peak - Binary Search - Index nums = " + findPeakElementBinarySearch(nums));

        int[] nums1 = {1,2,1,3,5,6,4};
        System.out.println("Peak - Binary Search - Index nums 1 = " + findPeakElementBinarySearch(nums1));
    }
}
