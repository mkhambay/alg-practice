package com.khambay.alg.sorting;

/**
 * Time - Best O(n log(n)) Worst O(n^2)
 * Space - O(log(n))
 *
 * - Partitioning in place (does not need an auxillary array and saves space)
 * - Shuffling is needed for performance guarantee - probabilistic guarantee
 * - Fastest in practice
 * - Not Stable
 */
public class QuickSort {

    public void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivotIndex = (left + right)/2;
        int pivotValue = arr[pivotIndex]; //Pick pivot point

        while(left <= right) {
            //Find element on left that should be on right
            while(arr[left] < pivotValue) {
                left++;
            }

            //Find element on right that should be on left
            while(arr[right] > pivotValue) {
                right--;
            }

            //Swap elements, move left and right indices
            if(left <= right) {
                swap(arr, left, right); //swaps elements
                left++;
                right--;
            }
        }
        //when left == right, its the new pivot Index
        pivotIndex = left;
        return pivotIndex;
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
