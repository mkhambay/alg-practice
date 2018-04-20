package com.khambay.alg.sorting;

public class KthSmallestSortedMatrixBinarySearch {

    public static int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 0;
            int j = matrix[0].length - 1;

            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }

            if(count < k) {
                lo = mid + 1; //go right
            }
            else {
                hi = mid; //go left
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println("Kth Smallest =" + kthSmallest(matrix, 8));
    }
}
