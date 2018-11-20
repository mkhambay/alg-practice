package com.khambay.alg.math;

/**
 * Time - O(n^2)
 * Space - O(num1 + num2)
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int p1 = i + j; //carry
                int p2 = i + j + 1; //last digit

                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + pos[p2]; //add the previous carry

                pos[p1] += sum / 10; //add carry
                pos[p2] = sum % 10; //get last digit
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("2 x 3 = " + multiply("2", "3"));
        System.out.println("123 x 456 = " + multiply("123", "456"));
    }
}
