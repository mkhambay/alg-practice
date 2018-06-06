package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class HouseRobber {

    public static int rob(int[] num) {
        int prevMax = 0;
        int max = 0;

        for (int x : num) {
            int temp = max;
            max = Math.max(prevMax + x, max);
            prevMax = temp;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,1};
        System.out.println("1,2,3,1 = " + rob(houses));

        int[] houses1 = {2,7,9,3,1};
        System.out.println("2,7,9,3,1 = " + rob(houses1));
    }
}
