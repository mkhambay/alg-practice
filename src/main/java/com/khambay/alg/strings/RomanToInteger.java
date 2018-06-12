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
            //peek ahead to see if next char is greater than current char ex. IV
            if(i < s.length() - 1 //boundry check for peek ahead
                    && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))) {
                result -= romanMap.get(s.charAt(i)); // ex. IV -> Removing value of I 1 from the result. When V = 5 added, only 4 gets added in total
            }
            else {
                result += romanMap.get(s.charAt(i)); // ex. IV -> V = 5 gets added, but we removed -1 above, so only 4 gets added
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String roman = "MXXIV";
        System.out.println(roman + " converted to int = " + romanToInt(roman));
    }
}
