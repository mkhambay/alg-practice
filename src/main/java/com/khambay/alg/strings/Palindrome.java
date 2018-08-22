package com.khambay.alg.strings;

public class Palindrome {

  public boolean isPalindrome(String stringToCheck) {

    if(stringToCheck == null || stringToCheck.length() < 1) {
      return true;
    }

    stringToCheck = stringToCheck.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    for(int i = 0, j = stringToCheck.length()-1; i < j; i++, j--) {
      if(stringToCheck.charAt(i) != stringToCheck.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    String palindromeString = "madam";
    String nonPalindromeString = "blah";
    String palindromeWithExtra = "A man, a plan, a canal: Panama";

    Palindrome palindrome = new Palindrome();

    System.out.println("Result for palindromeString=" + palindromeString + " is palindrome="
        + palindrome.isPalindrome(palindromeString));
    System.out.println("Result for nonPalindromeString=" + nonPalindromeString + " is palindrome="
        + palindrome.isPalindrome(nonPalindromeString));
    System.out.println("Result for palindromeWithExtra=" + palindromeWithExtra + " is palindrome="
            + palindrome.isPalindrome(palindromeWithExtra));
  }
}
