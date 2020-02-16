package com.khambay.alg.search;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
 * Time - O(log(min(m,n)))
 * Space - O(1)
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; //should be bigger
        int n2 = nums2.length; //should be smaller

        // If the longer array is used as the basis for the first cut, a range check must be performed.
        // It would be just easier to do it on the shorter array, which requires no checks whatsoever.
        // Also, moving only on the shorter array gives a run-time complexity of O(log(min(N1, N2)))
        if (n1 < n2) {
            return findMedianSortedArrays(nums2, nums1);	// Make sure A2/nums2 is the shorter one.
        }

        int lo = 0, hi = n2 * 2; //use shorter array for hi

        //binary search
        while (lo <= hi) {
            int c2 = (lo + hi) / 2;   // Try Cut 2
            int c1 = n1 + n2 - c2;  // Calculate Cut 1 accordingly

            // checking boundaries -
            // If any L falls out of the left boundary then L = INT_MIN
            // if any R falls out of the right boundary then R = INT_MAX
            double l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1)/2];
            double r1 = (c1 == n1 * 2) ? Integer.MAX_VALUE : nums1[(c1)/2];

            double l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1)/2];
            double r2 = (c2 == n2 * 2) ? Integer.MAX_VALUE : nums2[(c2)/2];

            //any number in lower halves <= any number in upper halves
            if (l1 > r2) {
                lo = c2 + 1;		// num1's lower half is too big; need to move to C2 right
            }
            else if (l2 > r1) {
                hi = c2 - 1;	// num2's lower half too big; need to move C2 left.
            }
            else {
                //if we cut the sorted array to two halves of EQUAL LENGTHS, then
                //median is the AVERAGE OF Max(lower_half) and Min(upper_half), i.e. the
                //two numbers immediately next to the cut
                return (Math.max(l1,l2) + Math.min(r1, r2)) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median = " + findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median = " + findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {1, 1, 1, 1};
        System.out.println("Median = " + findMedianSortedArrays(nums5, nums6));

        int[] nums7 = {};
        int[] nums8 = {1};
        System.out.println("Median = " + findMedianSortedArrays(nums7, nums8));
    }
}
