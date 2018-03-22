package com.khambay.alg.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Time - O(k*n^2)
 * k is the mapping length (2 -> ‘abc’, 3 -> ‘def’ and so on)
 * n is the number of digits
 */
public class LetterCombinationsPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();

        if(digits.isEmpty()) {
            return ans;
        }

        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        for(int i = 0; i < digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));

            while(ans.peek().length() == i) {
                String t = ans.remove();

                for(char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }

    /**
     * Time - O(n^n) - n number of digits
     * Space - O(m) - m number of unique combinations for every recursive call
     */
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
        List<String> ans = letterCombinations("23");
        System.out.println(ans);

        List<String> ans1 = letterCombinationsRecursive("23");
        System.out.println(ans1);
    }
}
