package com.khambay.alg.strings;

public class TestCode {

    public static void main(String args[]) {

        System.out.println("Numeric value z=" + Character.getNumericValue('z'));
        System.out.println("Numeric value Z=" + Character.getNumericValue('Z'));
        System.out.println("Numeric value a=" + Character.getNumericValue('a'));
        System.out.println("Numeric value A=" + Character.getNumericValue('A'));

        int val = Character.getNumericValue('a');
        System.out.println("val=" + val);
    }
}
