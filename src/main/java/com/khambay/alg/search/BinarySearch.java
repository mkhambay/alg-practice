package com.khambay.alg.search;

public class BinarySearch {

    public int binarySearch(int[] a, int x, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        if(a[mid] < x) {
            return binarySearch(a, x, mid +1, high);
        }
        else if(a[mid] > x) {
            return binarySearch(a, x, low, mid - 1);
        }
        else {
            return mid;
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
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("Search 8 = " + binarySearch.binarySearch(arr,8, 0, arr.length-1));
        System.out.println("Search 10 = " + binarySearch.binarySearch(arr,10, 0, arr.length-1));
    }
}
