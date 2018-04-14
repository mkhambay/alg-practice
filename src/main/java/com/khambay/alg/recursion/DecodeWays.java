package com.khambay.alg.recursion;


/**
 * Dynamic Programming - Bottom up with memoization
 * Time and Space - O(n)
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        //to help process first result size is n + 1 and its set to 1
        //If the last two digits form a valid character we sum i + 1 and i + 2
        int[] memo = new int[n + 1];
        memo[n] = 1;

        // If the last digit is not 0, then last digit must add to
        // the number of words, add to the count
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        //start at the second last digit
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') {  //if digit 0, skip
                continue;
            }
            else {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? //If the last two digits form a valid character
                                                                            // smaller than or equal to 26,
                                memo[i + 1] + memo[i + 2] :                 // then consider last two digits to add to count
                                memo[i + 1];                                // otherwise carry forward the earlier count
            }

        return memo[0]; //final count is at index 0
    }

    public static void main(String[] args) {
        String s = "1234";
        System.out.println("Decode ways = " + numDecodings(s));
    }
}
