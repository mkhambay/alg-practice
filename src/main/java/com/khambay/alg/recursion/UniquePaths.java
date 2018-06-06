package com.khambay.alg.recursion;

/**
 * Dynamic Programming
 * Time and Space - O(m*n)
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //intialize first row and column with 1 to prevent out of boundry
        for(int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }

        for(int col= 0; col < n; col++) {
            dp[0][col] = 1;
        }

        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                dp[row][col] = dp[row-1][col] + dp[row][col-1]; //to get here only 2 ways, from top or from the left
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println("7 x 3 = " + uniquePaths(6, 4));
        System.out.println("7 x 3 = " + uniquePaths(7, 3));
    }
}
