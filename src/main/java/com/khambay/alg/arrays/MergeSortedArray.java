package com.khambay.alg.arrays;

/**
 * Same as SortedMerge question
 * Time - O(m+n)
 * Space - O(1)
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; //pointer pointing to last element of nums1
        int j = n - 1; //pointer pointing to last element of nums2
        int k = m + n - 1; //pointer pointing to last element of merged array

        while(j >= 0) { //running over the smaller array
            if(i >= 0 && nums1[i] > nums2[j]) { //will also come here when smaller array has been exhausted j == 0
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,0,0,0};
        int m = 4;
        printArray(nums1);
        int[] nums2 = {3,4,5};
        int n = 3;
        printArray(nums2);
        merge(nums1, m, nums2, n);
        System.out.println("Merged array");
        printArray(nums1);
    }
}
