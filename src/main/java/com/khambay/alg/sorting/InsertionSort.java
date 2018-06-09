package com.khambay.alg.sorting;

/**
 * Compare the value with every previous value till start of array. If any is bigger, swap.
 * Time - Best O(n) and worst O(n^2)
 * Space - O(1)
 *
 * - Stable
 */
public class InsertionSort {

    public void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void printArray(int arr[]) {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String args[]) {
        InsertionSort insertionSort = new InsertionSort();
        int arr[] = {10,2,8,5,7,4,3,9,1,6};
        System.out.println("Original array");
        insertionSort.printArray(arr);

        insertionSort.insertionSort(arr);

        System.out.println("Sorted array");
        insertionSort.printArray(arr);
    }
}
