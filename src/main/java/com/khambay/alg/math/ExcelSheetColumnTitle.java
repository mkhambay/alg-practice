package com.khambay.alg.math;

/**
 * Time and Space - O(n)
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            n -= 1;

            int lastDigit = n % 26;
            char c = (char)(lastDigit + 'A');
            sb.insert(0, c); //building the string in reverse

            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("1 = " + convertToTitle(1));
        System.out.println("28 = " + convertToTitle(28));
        System.out.println("701 = " + convertToTitle(701));
    }
}
