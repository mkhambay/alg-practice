package com.khambay.alg.strings;

/**
 * This class tests strings if they are palindrome 
 * @author mandeepkhambay
 */
public class Palindrome {

  /**
   * Method checks if the string is a palindrome
   * @param String stringToCheck - string to check
   * @return boolean - if its a palindrome
   */
  public boolean isPalindrome(String stringToCheck) {
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
