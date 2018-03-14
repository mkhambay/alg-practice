package com.khambay.alg.arrays;

import java.util.HashSet;

/**
 * Class to find pairs in an array whose sum matches given sum.
 */
public class PairsFinder {


    /**
     * Find Single pairs of sum using nested for loops - Big O(n^2)
     * @param sum
     * @param arr
     * @throws Exception
     */
    public void findPairsNestedFor(int sum, int arr[]) throws Exception {
        if(arr == null || arr.length == 0) {
            throw new Exception ("Array is empty or null");
        }

        for(int i = 0; i < arr.length; i++) {
            for(int y = i + 1; y < arr.length; y++) {
                if(sum - arr[i] == arr[y]) {
                    System.out.println("Pair = " + arr[i] + " " + arr[y]);
                }
            }
        }
    }

    /**
     * Find all pairs of sum using set - Big O(n)
     * @param sum
     * @param arr
     * @throws Exception
     */
    public void findAllPairs(int sum, int arr[]) throws Exception {
        HashSet<Integer> nums = new HashSet();

        if(arr == null || arr.length == 0) {
            throw new Exception ("Array is empty or null");
        }

        for(int i = 0; i < arr.length; i++) {
            nums.add(arr[i]);
        }

        for(int i = 0; i < arr.length; i++) {
            if(nums.contains(sum - arr[i])) {
                System.out.println("Pair = " + arr[i] + " " + (sum - arr[i]));
            }
        }
    }

    /**
     * Find Single Pairs of sum using set - Big O(n)
     * @param sum
     * @param arr
     * @throws Exception
     */
    public void findSinglePairs(int sum, int arr[]) throws Exception {
        HashSet<Integer> nums = new HashSet();

        if (arr == null || arr.length == 0) {
            throw new Exception("Array is empty or null");
        }

        nums.add(arr[0]);
        for(int i = 0; i < arr.length; i++) {
            if(nums.contains(sum - arr[i])) {
                System.out.println("Pair = " + arr[i] + " " + (sum - arr[i]));
            }
            else {
                nums.add(arr[i]);
            }
        }
    }

    public void findPairSumsGabe(int[] array, int sum) {
        HashSet<Integer> elements = new HashSet<>();

        for(int x : array) {
            int complement = sum - x;
            if(elements.contains(complement)
                    && !elements.contains(x) //this helps return a unique list of pairs
                    ) {
                System.out.println("Pair = " + x + " " + complement);
            }
            elements.add(x);
        }
    }

    public static void main(String args[]) throws Exception {
        PairsFinder p = new PairsFinder();
        int arr[] = {1, 7, 4, 8, 2, 3};

        System.out.println("Find Pairs");
        p.findAllPairs(5, arr);

        System.out.println("Find Pairs - Gabe");
        p.findPairSumsGabe(arr, 5);

        System.out.println("Find Single Pairs Nested For");
        p.findPairsNestedFor(5, arr);

        System.out.println("Find Single Pairs");
        p.findSinglePairs(5, arr);
    }
}
