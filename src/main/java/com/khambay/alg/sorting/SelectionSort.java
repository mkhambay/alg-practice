package com.khambay.alg.sorting;

/**
 * Starting with the first element, find the index of the smallest element, swap
 *
 * Time - O(n^2)
 * Space - O(1)
 */
public class SelectionSort {

    public void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min_idx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            swap(arr, min_idx, i);
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
        SelectionSort selectionSort = new SelectionSort();
        int arr[] = {10,2,8,5,7,4,3,9,1,6};
        System.out.println("Original array");
        selectionSort.printArray(arr);

        selectionSort.sort(arr);

        System.out.println("Sorted array");
        selectionSort.printArray(arr);
    }
}
