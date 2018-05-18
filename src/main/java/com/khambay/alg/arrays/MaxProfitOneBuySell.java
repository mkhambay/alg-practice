package com.khambay.alg.arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class MaxProfitOneBuySell {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else {
                maxProfit = Math.max(maxProfit, (prices[i] - minPrice));
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit 7, 1, 5, 3, 6, 4 = " + maxProfit(prices));

        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit 7, 6, 4, 3, 1 = " + maxProfit(prices1));
    }
}
