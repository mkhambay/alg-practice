package com.khambay.alg.search;

/**
 * Time - O(logn)
 * Space - O(1)
 */
public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums == null || nums.length < 1) {
            return result;
        }

        int start = binarySearch(nums, target);
        if(start == nums.length || nums[start] != target) {
            return result;
        }

        int end = binarySearch(nums, target+1);

        result = new int[]{start, (end - 1)};
        return result;
    }

    //find the first number that is greater than or equal to target.
    private static int binarySearch(int[] A, int target) {
        int low = 0, high = A.length;

        while (low < high) {
            int mid = (low + high) /2;

            if (A[mid] < target) {
                low = mid + 1; //go right
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid; //go left
            }
        }
        return low;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }


    public static void main(String[] args) {
        int[] A = {5,7,7,8,8,10};
        int[] range = searchRange(A, 8);
        System.out.print("{5,7,7,8,8,10} and target 8 = ");
        printArray(range);

        range = searchRange(A, 6);
        System.out.print("{5,7,7,8,8,10} and target 6 = ");
        printArray(range);

        int[] B = {2,2};
        int[] range1 = searchRange(B, 3);
        printArray(range1);
    }
}
