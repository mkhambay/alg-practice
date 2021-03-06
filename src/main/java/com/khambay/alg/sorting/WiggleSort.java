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
public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        int median = KthLargestUnsortedArrayQuickSelect.findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;

        //After you get median element, the 'nums' is partially sorted such that the first half is larger or equal
        //to the median, the second half is smaller or equal to the median

        while (i <= right) {
            int index = newIndex(i,n);

            if (nums[index] > median) { //elements larger than the 'median' are put into the first odd slots
                swap(nums, newIndex(left,n), index);
                left++;
                i++;
            }
            else if (nums[index] < median) { //elements smaller than the 'median' are put into the last even slots
                swap(nums, newIndex(right,n), index);
                right--;
            }
            else {
                i++; //equal to median
            }
        }
    }

    // http://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java/81844
    // All these indexes are less than n / 2 so multiplying by 2 and add 1
    // (to make them go to odd place) and then mod by n will always guarantee that they are less than n.
    //
    // n|1 does it that it gets the next odd number to n if it was even
    // if n = 6 for example 110 | 1 = 111 = 7
    // if n = 7 for example 111 | 1 = 111 = 7
    // Original Index => Mapped Index
    // 0 => (1 + 2 x 0) % 6 = 1 % 7 = 1
    // 1 => (1 + 2 x 1) % 6 = 3 % 7 = 3
    // 2 => (1 + 2 x 2) % 6 = 5 % 7 = 5
    // 3 => (1 + 2 x 3) % 7 = 7 % 7 = 0
    // 4 => (1 + 2 x 4) % 7 = 9 % 7 = 2
    // 5 => (1 + 2 x 5) % 7 = 11 % 7 = 4
    private static int newIndex(int index, int n) {
        int result = (1 + 2 * index) % (n | 1);
        return result;
    }

    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    public static void printArray(int arr[]) {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] nums = {6,13,5,4,5,2};
        printArray(nums);
        wiggleSort(nums);
        printArray(nums);
    }
}
