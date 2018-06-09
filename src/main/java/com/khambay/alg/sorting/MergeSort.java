package com.khambay.alg.sorting;

/**
 * Time - Best and Worst - O(nlogn)
 * Space - O(n)
 *
 * - Use auxiliary array
 * - Keep split into 2 array
 * - Sort each of them
 * - Merge both arrays
 * - Stable
 */
public class MergeSort {

    void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    void mergesort(int[] array, int[] helper, int low, int high) {
        if(low < high) {
            int middle = (low + high)/2;
            mergesort(array, helper, low, middle); //Sort left half
            mergesort(array, helper, middle+1, high); //Sort right half
            merge(array, helper, low, middle, high); //Sort and Merge them
        }
    }

    void merge(int[] array, int[] helper, int low, int middle, int high) {
        //Copy into helper array
        for(int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        //Iterate through helper array. Compare left and right half, copying back
        //the smaller element from the two halves into the original array
        while(helperLeft <= middle && helperRight <= high) {
            if(helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else { //If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        //Copy the rest of the left side of the array into the target array
        int remaining = middle - helperLeft;
        for(int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public void printArray(int arr[]) {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int arr[] = {10,2,8,5,7,4,3,9,1,6};
        System.out.println("Original array");
        mergeSort.printArray(arr);

        mergeSort.mergesort(arr);

        System.out.println("Sorted array");
        mergeSort.printArray(arr);
    }
}
