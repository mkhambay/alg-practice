package com.khambay.alg.arrays;

import java.util.Random;

/**
 * Fisher-Yates Algorithm
 *
 * Time and Space - O(n)
 */
public class ShuffleAnArray {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ShuffleAnArray solution = new ShuffleAnArray(nums);

        System.out.println("Shuffle");
        solution.printArray(solution.shuffle());

        System.out.println("Reset");
        solution.printArray(solution.reset());

        System.out.println("Shuffle");
        solution.printArray(solution.shuffle());
    }
}
