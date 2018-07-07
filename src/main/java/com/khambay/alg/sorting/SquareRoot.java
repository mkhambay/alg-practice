package com.khambay.alg.sorting;

/**
 * Time - O(logn) - Binary Search
 * Space - O(1)
 */
public class SquareRoot {

    public static int floorSqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int start = 1;
        int end = x;
        int result = 0;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (mid <= x/mid) { //go right
                start = mid + 1;
                result = mid; //capture result
            } else {
                end = mid - 1; //go left
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("Sqrt of 4 = " + floorSqrt(4));
        System.out.println("Sqrt of 8 = " + floorSqrt(8));
        System.out.println("Sqrt of 64 = " + floorSqrt(64));
    }
}
