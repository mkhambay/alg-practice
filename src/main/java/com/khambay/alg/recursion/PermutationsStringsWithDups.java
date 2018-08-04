package com.khambay.alg.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsStringsWithDups {

    public static Map<Character, Integer> buildFreqTable(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void printPerms(Map<Character, Integer> map, String prefix, String s, List<String> result) {
        if (prefix.length() == s.length()) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c,  count - 1);
                printPerms(map, prefix + c, s, result);
                map.put(c,  count);
            }
        }
    }

    public static List<String> printPerms(String s) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "aabbccc";
        List<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }
}
