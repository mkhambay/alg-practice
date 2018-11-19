package com.khambay.alg.math;

/**
 * Similar to Sum lists
 * Time - O(a + b)
 * Space - O(n)
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) { //a and b can be of different lengths
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.insert(0,sum % 2);  //Note - divide by 2 and not mod 10 - either 1 or 0 - its an XOR
            carry = sum / 2; //Note - carry is 1 or 0, but its sum / 2 and not mod 10
        }

        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("a = 11 b = 1 Result = " + addBinary("11", "1"));
        System.out.println("a = 1010 b = 1011 Result = " + addBinary("1010", "1011"));
    }
}
