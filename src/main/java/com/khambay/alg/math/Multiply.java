package com.khambay.alg.math;

public class Multiply {

    public static int multiply(int x, int y) {
        int big = x < y ? y : x;
        int small = x < y ? x : y;
        return multiplyRecursive(small, big);
    }

    public static int multiplyRecursive(int small, int big) {
        if (small == 0) {
            //If any number multiplied by 0 will give a product of 0
            return 0;
        } else if (small == 1) {
            //If any number multiplied by 1 will give the number itself being multiplied with
            return big;
        }

        //Divide small by 2  7 >> 1 = 3
        int smallHalved = small >> 1;
        int product = multiplyRecursive(smallHalved, big);

        if (small % 2 == 0) {
            return product + product;
        }
        else {
            return product + product + big;
        }
    }


    public static void main(String[] args) {
        int x = 8;
        int y = 7;
        System.out.println("Odd - Product 8 * 7 = " + multiply(x, y));

        int x1 = 8;
        int y1 = 10;
        System.out.println("Even - Product 8 * 10 = " + multiply(x1, y1));
    }
}
