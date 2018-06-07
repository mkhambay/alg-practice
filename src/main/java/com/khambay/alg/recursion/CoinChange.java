package com.khambay.alg.recursion;

import java.util.Arrays;

/**
 * Time - O(amount * n) - n is the denomination count
 * Space - O(amount)
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; //since we initialize array with amount + 1, if its still bigger than amount, we didn't find the result, return -1.
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println("Result = " + coinChange(coins, 11));
    }
}
