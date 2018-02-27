package com.khambay.alg.sorting;

public class SortedMerge {

    public static void merge(int[] a, int[] b, int idxEndA, int idxEndB) {
        int idxMerged = a.length - 1;

        while (idxEndB >= 0) {
            if (idxEndA >= 0 && a[idxEndA] > b[idxEndB]) {
                a[idxMerged] = a[idxEndA];
                idxEndA--;
            } else {
                a[idxMerged] = b[idxEndB];
                idxEndB--;
            }
            idxMerged--;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 5, 6, 8, 10, 20, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 5, 6, 7, 7};

        merge(a, b, 7, 5);

        System.out.print("[");
        for(int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println(a[a.length-1] + "]");
    }
}
