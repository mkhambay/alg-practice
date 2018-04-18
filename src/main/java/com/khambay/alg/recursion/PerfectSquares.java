package com.khambay.alg.recursion;

import java.util.Arrays;

/**
 * Time - O(n^2)
 * Space - O(n)
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //dp[1] = dp[0]+1 = 1
        System.out.println("No of Perfect Squares 1 = " + numSquares(1));

        //dp[2] = dp[1]+1 = 2
        System.out.println("No of Perfect Squares 2 = " + numSquares(2));

        //dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
        //      = Min{ dp[3]+1, dp[0]+1 }
        System.out.println("No of Perfect Squares 4 = " + numSquares(4));

        //dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
        //      = Min{ dp[4]+1, dp[1]+1 }
        System.out.println("No of Perfect Squares 5 = " + numSquares(5));
        System.out.println("No of Perfect Squares 12 = " + numSquares(12));

        //dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
        //       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
        System.out.println("No of Perfect Squares 13 = " + numSquares(13));
    }
}
