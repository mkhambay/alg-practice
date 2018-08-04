package com.khambay.alg.recursion;

import java.util.Arrays;

/**
 * Time - O(n) - with the help of memo, otherwise it would have been O(3^n)
 */
public class TripleStep {

    public static int countWays(int n) {
        //n + 1 to store the result and return that
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    public static int countWays(int n, int[] memo) {
        if (n < 0) { //base case, reached end
            return 0;
        }
        else if (n == 0) { //array starts at 0, return for 1 step
            return 1;
        }
        else if (memo[n] > -1) { //get from cache
            return memo[n];
        }
        else {
            int one = countWays(n - 1, memo);
            int two = countWays(n - 2, memo);
            int three = countWays(n - 3, memo);

            memo[n] = one + two + three;
//                    countWays(n - 1, memo) +
//                            countWays(n - 2, memo) +
//                            countWays(n - 3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int ways = countWays(n);
        System.out.println(ways);
    }
}
