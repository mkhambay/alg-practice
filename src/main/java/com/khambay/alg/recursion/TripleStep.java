package com.khambay.alg.recursion;

import java.util.Arrays;

public class TripleStep {

    public static int countWays(int n) {
        //n + 1 to store the result and return that
        int[] map = new int[n + 1];
        Arrays.fill(map, -1);
        return countWays(n, map);
    }

    public static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        }
        else if (memo[n] > -1) {
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
