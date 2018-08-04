package com.khambay.alg.recursion;

public class MagicIndex {

    public static int magicIndex(int[] array) {
        return magicIndexBinarySearch(array, 0, array.length - 1);
    }

    //Regular binary search - looking for the index as the value being searched - in this case mid
    public static int magicIndexBinarySearch(int[] a, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        if(a[mid] < mid) {
            return magicIndexBinarySearch(a,mid +1, high);
        }
        else if(a[mid] > mid) {
            return magicIndexBinarySearch(a, low, mid - 1);
        }
        else {
            return mid;
        }
    }

    public static int magicIndexWithDuplicates(int[] array) {
        return magicIndexWithDuplicates(array, 0, array.length - 1);
    }

    public static int magicIndexWithDuplicates(int[] a, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        int midValue = a[mid];

        if (midValue == mid) {
            return mid;
        }
        /* Search left */
        int leftIndex = Math.min(mid - 1, midValue);
        int left = magicIndexWithDuplicates(a, low, leftIndex);
        if (left >= 0) { //match found
            return left;
        }

        /* Search right */
        int rightIndex = Math.max(mid + 1, midValue);
        int right = magicIndexWithDuplicates(a, rightIndex, high);

        return right;
    }


    public static void main(String[] args) {
        int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println("Magic Index = " + magicIndex(arr));

        int[] arr1 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println("Magic Index with duplicates = " + magicIndexWithDuplicates(arr1));
    }
}
