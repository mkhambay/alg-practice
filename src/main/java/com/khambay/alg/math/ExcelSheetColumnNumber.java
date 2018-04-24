package com.khambay.alg.math;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length();  i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "A";
        String AA = "AA";
        String AB = "AB";
        String MN = "MN";

        System.out.println("A = " + titleToNumber(A));
        System.out.println("AA = " + titleToNumber(AA));
        System.out.println("AB = " + titleToNumber(AB));
        System.out.println("MN = " + titleToNumber(MN));
    }
}
