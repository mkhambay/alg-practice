package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            //Get minimum height
            int minHeight = Math.min(height[l], height[r]);
            int length = r - l;
            int area = minHeight * length;

            maxArea = Math.max(maxArea, area);

            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area = " + maxArea(height));
    }
}
