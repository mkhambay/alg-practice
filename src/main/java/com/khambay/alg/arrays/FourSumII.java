package com.khambay.alg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Time and Space - O(n^2)
 */
public class FourSumII {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;

        if(A == null || A.length < 1 ||
                B == null || B.length < 1 ||
                C == null || C.length < 1 ||
                D == null || D.length < 1) {
            return result;
        }

        //Map of Sum and its count
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                //find a negative sum in the map. Together they will result in 0
                result += map.getOrDefault(-sum, 0);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println("Result = " + fourSumCount(A, B, C, D));
    }
}
