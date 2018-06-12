package com.khambay.alg.math;

/**
 * https://en.wikipedia.org/wiki/Prime_number
 *
 * A prime number (or a prime) is a natural number greater than 1
 * that cannot be formed by multiplying two smaller natural numbers.
 *
 * A natural number greater than 1 that is not prime is called a composite number.
 * For example, 5 is prime because the only ways of writing it as a product, 1 × 5 or 5 × 1, involve 5 itself.
 * However, 6 is composite because it is the product of two numbers (2 × 3) that are both smaller than 6
 *
 * Prime - 2, 3, 5, 7, 11
 * Composite - 4, 6, 8, 9, 10, 12
 *
 * Time and Space - O(n)
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) { //prime starts at 2
            if (notPrime[i] == false) { //its prime
                count++;
                for (int j = 2; i*j < n; j++) { //set all the products to true
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count primes for 12 = " + countPrimes(12));
    }
}
