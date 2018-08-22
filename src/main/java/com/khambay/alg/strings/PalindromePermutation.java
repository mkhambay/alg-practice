package com.khambay.alg.strings;

/**
 * Time - O(n)
 * Space - O(1)
 * Palindrome - all characters with even count OR just one with odd count
 */
public class PalindromePermutation {

    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    //Check no more than one character has an odd count
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for(int count : table) {
            if(count % 2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    //Count how may times each character appears
    int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[26];

        for(char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /* Map each character to a number a = 0, b = 1, c = 2
     * Case insensitive
     * Non-letter maps to -1 */
    int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(c);

        if(a <= val && val <= z) {
            return val - a;
        }
        else if(A <= val && val <= Z) {
            return val - A;
        }
        return -1;
    }

    public static void main(String args[]) {
        String palinOdd = "Tact Coa";
        String notPalin = "Blah";
        String notPalinNumber = "335ASC";
        String palinEven = "degged";


        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println("Is " + palinOdd + " Palindrome Permutation="
                + palindromePermutation.isPermutationOfPalindrome(palinOdd));
        System.out.println("Is " + notPalin + " Palindrome Permutation="
                + palindromePermutation.isPermutationOfPalindrome(notPalin));
        System.out.println("Is " + palinEven + " Palindrome Permutation="
                + palindromePermutation.isPermutationOfPalindrome(palinEven));
        System.out.println("Is " + notPalinNumber + " Palindrome Permutation="
                + palindromePermutation.isPermutationOfPalindrome(notPalinNumber));
    }
}
