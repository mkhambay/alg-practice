package com.khambay.alg.recursion;

import java.util.Arrays;

/**
 * Time - O(a * c) c - number of coins and a - amount
 * Space - O(a)
 *
 * similar to Perfect Squares
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); //set all amounts to amount + 1. This is needed for the final check in return statement
        dp[0] = 0;

        for (int a = 1; a < dp.length; a++) { //fill in dp for amounts starting at 1 upto the amount needed ex. 1-11
            for (int c = 0; c < coins.length; c++) { //figure out the minimum number of coins need to make that amount a
                if (coins[c] <= a) { //coin value should be less than or equal to amount ex. to make amount 2, 1 coin of value 2 is needed
                    dp[a] = Math.min(dp[a], dp[a - coins[c]] + 1); //we are looking for the minimum number of coins needed to make that amount and +1 for the current coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; //since we initialize array with amount + 1, if its still bigger than amount, we didn't find the result, return -1.
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println("Result = " + coinChange(coins, 11));

        int[] coins1 = {2};
        System.out.println("Result 1 = " + coinChange(coins1, 3));
    }
}
