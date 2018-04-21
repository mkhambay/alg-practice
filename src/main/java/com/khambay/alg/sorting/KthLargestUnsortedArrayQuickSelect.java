package com.khambay.alg.sorting;

/**
 * Quickselect - https://en.wikipedia.org/wiki/Quickselect
 *
 * Its is a selection algorithm to find the kth smallest/largest element in an unordered list.
 * It is related to the quicksort sorting algorithm.
 *
 * Instead of recursing into both sides, as in quicksort, quickselect only recurses into one side
 * – the side with the element it is searching for. This reduces the average complexity
 * from O(n log n) to O(n), with a worst case of O(n2).
 *
 * Quickselect is generally implemented as an in-place algorithm.
 *
 * Beyond selecting the k'th element, it also partially sorts the data.
 *
 * Time - O(n) average, worst would be O(n^2)
 * Space - O(1)
 */
public class KthLargestUnsortedArrayQuickSelect {

    public static int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        int kthLargest = nums.length - k; //ex. 2nd largest is the 5th element in a array of size 6
        return getKth(kthLargest, nums, 0, nums.length - 1);
    }

    public static int getKth(int k, int[] nums, int start, int end) {
        int pivotValue = nums[end];

        int left = start;
        int right = end;

        while (true) {
            while (nums[left] < pivotValue && left < right) {
                left++;
            }

            while (nums[right] >= pivotValue && right > left) {
                right--;
            }

            if (left == right) {
                swap(nums, left, end);
                break;
            }

            swap(nums, left, right);
        }

        if (k == left) {
            return pivotValue;
        } else if (k < left) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println("2nd largest = " + findKthLargest(nums, 2));
    }
}
