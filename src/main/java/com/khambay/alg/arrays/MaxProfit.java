package com.khambay.alg.arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * Buy one and sell one share of the stock multiple times.
 *
 * Time - O(n)
 * Space - O(1)
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int previousPrice = prices[i - 1];

            //if current price is greater than previous price
            //capture the difference as profit and add to profit total

            if(currentPrice > previousPrice) {
                maxProfit += currentPrice - previousPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3,6,1,5};
        System.out.println("Max Profit = " + maxProfit(prices));
    }
}
