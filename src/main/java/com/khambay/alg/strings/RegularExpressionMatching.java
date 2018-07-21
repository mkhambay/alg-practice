package com.khambay.alg.strings;


/**
 * https://www.youtube.com/watch?v=l3hda49XcDE
 *
 * https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation?page=2
 *
 * Time and Space - O(m*n)
 */
public class RegularExpressionMatching {

    public static boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean dp[][] = new boolean[text.length + 1][pattern.length + 1]; //thats why everything below is - 1

        dp[0][0] = true; //if both string and pattern are empty, its true, its a pattern match

        //Set first row - Deals with patterns like a* or a*b* or a*b*c*
        for (int j = 1; j < dp[0].length; j++) {
            if (pattern[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2]; //ex xa* is same as x as a* is zero or more a's - take the value of without a
            }
        }

        //fill the result diagonal across down
        for (int i = 1; i < dp.length; i++) { //text
            for (int j = 1; j < dp[0].length; j++) { //pattern

                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) { // - 1 as we start the loop with 1
                    dp[i][j] = dp[i - 1][j - 1]; //disregard this string char and pattern and use diagonal previous
                }
                else if (pattern[j - 1] == '*')  {
                    dp[i][j] = dp[i][j - 2]; //ex xa* is same as x as a* is zero or more a's - take the value of without a

                    if(dp[i][j] == false) { //we look at the value on top
                        if (pattern[j - 2] == '.' //if previous pattern is "."
                                || pattern[j - 2] == text[i - 1]) //check if previous pattern matches the text ex. p - a* matches t - a
                        {
                            dp[i][j] = dp[i - 1][j]; //value on top/above
                        }
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        //final answer at the end of the diagonal
        return dp[text.length][pattern.length];
    }


    public static void main(String[] args) {
        System.out.println("s = xaabyc and p = xa*b.c Result = " + isMatch2("xaabyc", "xa*b.c"));
        System.out.println("s = aa and p = a Result = " + isMatch2("aa", "a"));
        System.out.println("s = aa and p = a* Result = " + isMatch2("aa", "a*"));
        System.out.println("s = ab and p = .* Result = " + isMatch2("ab", ".*"));
    }
}
