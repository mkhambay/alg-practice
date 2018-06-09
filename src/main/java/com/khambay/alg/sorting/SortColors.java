package com.khambay.alg.sorting;

/**
 * Sorting, 3 pointer arrays
 * Time - O(n)
 * Space - O(1)
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        int k = nums.length - 1;

        for(int i = 0; i <= k; i++) { //note i <= k and not nums.length
            if(nums[i] == 0) {
                swap(nums, i, j);
                j++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, k);
                i--; //move i back to re-evaluate the value we got in the swap with k above
                k--;
            }
        }
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void printArray(int arr[]) {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] input = {2,0,2,1,0,1,0,1};
        printArray(input);
        sortColors(input);
        printArray(input);
    }
}
