package com.khambay.alg.sorting;

public class QuickSort {

    public void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if(left < index - 1) { //Sort left half
            quickSort(arr, left, index -1);
        }
        if(index < right) { //Sort right half
            quickSort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right)/2]; //Pick pivot point
        while(left <= right) {
            //Find element on left that should be on right
            while(arr[left] < pivot) {
                left++;
            }

            //Find element on right that should be on left
            while(arr[right] > pivot) {
                right--;
            }

            //Swap elements, move left and right indices
            if(left <= right) {
                swap(arr, left, right); //swaps elements
                left++;
                right--;
            }
        }
        return left;
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

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int arr[] = {10,2,8,5,7,4,3,9,1,6};
        System.out.println("Original array");
        quickSort.printArray(arr);

        quickSort.quickSort(arr, 0, arr.length-1);

        System.out.println("Sorted array");
        quickSort.printArray(arr);
    }
}
