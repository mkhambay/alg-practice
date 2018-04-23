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
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            int index = newIndex(i,n);

            if (nums[index] > median) {
                swap(nums, newIndex(left,n), index);
                left++;
                i++;
            }
            else if (nums[index] < median) {
                swap(nums, newIndex(right,n), index);
                right--;
            }
            else {
                i++;
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
