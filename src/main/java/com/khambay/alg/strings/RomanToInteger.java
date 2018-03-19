package com.khambay.alg.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Time and Space - O(n)
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // create a hash table to store the dictorary
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            //peek ahead to see if next char is less than current char
            if(i < s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))) {
                result -= romanMap.get(s.charAt(i));
            }
            else {
                result += romanMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String roman = "MXXIV";
        System.out.println(roman + " converted to int = " + romanToInt(roman));
    }
}
