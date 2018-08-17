package com.khambay.alg.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time - O(n^n) - n number of digits - Similar to PermutationsIntegers and Subsets
 * Space - O(m) - m number of unique combinations for every recursive call
 */
public class LetterCombinationsPhoneNumber {

    public static List<String> letterCombinationsRecursive(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.equals("")) {
            return result;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        buildCombinations(result, new StringBuilder(), digits, 0, map);

        return result;

    }

    public static void buildCombinations(List<String> result, StringBuilder sb, String digits, int index, HashMap<Character, String> map){
        //Base case
        if(index >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char d = digits.charAt(index);
        char[] arr = map.get(d).toCharArray();

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            buildCombinations(result, sb, digits, index + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = letterCombinationsRecursive("23");
        System.out.println(ans);
    }
}
