package com.khambay.alg.math;

/**
 * Time - O(logn) - Binary Search
 * Space - O(1)
 */
public class SquareRoot {

    public static int floorSqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int low = 1;
        int high = x;
        int result = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (mid <= x/mid) { //go right
                low = mid + 1;
                result = mid; //capture result
            } else {
                high = mid - 1; //go left
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
