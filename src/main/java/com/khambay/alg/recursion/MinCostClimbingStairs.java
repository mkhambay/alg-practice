package com.khambay.alg.recursion;

/**
 * DP
 *
 * Cost at step 0 and 1 are already provided and do not need to be computed.
 * Where as from step 2 onward, the cost depends on the previous step plus the cost of the current,
 * the previous step being i-1 or i-2
 *
 * Time - O(n)
 * Space - O(1)
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Min cost {10, 15, 20} = " + minCostClimbingStairs(cost));

        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Min cost {11, 100, 1, 1, 1, 100, 1, 1, 100, 1} = " + minCostClimbingStairs(cost1));

    }
}
