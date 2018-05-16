package com.khambay.alg.arrays;

/**
 * Array - 2 pointer - Similar to MaxArea
 * Time - O(n)
 * Space - O(1)
 */
public class TrappingRainWater {

    public static int trap(int[] height){
        int left = 0;
        int right = height.length-1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){ //if left end is smaller, we are assured that the water trapped would be dependant on height of left bar in current direction(from left to right).
                result += (leftMax - height[left]);       // if leftmax is greater than height of current left, ex. 1, 2 difference is the water that can be stored
                left++;
            }
            else { //if right end is smaller, we start iterating in opposite direction(from right to left)
                result += (rightMax - height[right]);    // if rightmax is greater than height of current right, ex. 10, 9
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Output = " + trap(arr));
    }
}
