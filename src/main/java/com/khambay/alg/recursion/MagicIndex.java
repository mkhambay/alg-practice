package com.khambay.alg.recursion;

public class MagicIndex {

    public static int magicIndex(int[] array) {
        return magicIndexBinarySearch(array, 0, array.length - 1);
    }

    public static int magicIndexBinarySearch(int[] array, int start, int end) {
        if(start > end) {
            return -1;
        }

        int midIndex = (start + end)/2;
        int midValue = array[midIndex];
        if(midValue == midIndex) {
            return midIndex;
        }
        else if(midValue > midIndex) {
            //go left
            return magicIndexBinarySearch(array, start, midIndex - 1);
        }
        else {
            //go right
            return magicIndexBinarySearch(array, midIndex + 1, end);
        }
    }

    public static int magicIndexWithDuplicates(int[] array) {
        return magicIndexWithDuplicates(array, 0, array.length - 1);
    }

    public static int magicIndexWithDuplicates(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }
        /* Search left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicIndexWithDuplicates(array, start, leftIndex);
        if (left >= 0) { //match found
            return left;
        }

        /* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicIndexWithDuplicates(array, rightIndex, end);

        return right;
    }


    public static void main(String[] args) {
        int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println("Magic Index = " + magicIndex(arr));

        int[] arr1 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println("Magic Index with duplicates = " + magicIndexWithDuplicates(arr1));
    }
}
