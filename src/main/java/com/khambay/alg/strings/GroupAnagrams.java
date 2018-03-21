package com.khambay.alg.strings;

import java.util.*;

/**
 * Time - O(n)
 * Space - O(n)
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagrams = new HashMap<>();

        //Arrays.sort and then compare
        for(int i = 0; i < strs.length; i++) {
            String originalString = strs[i];
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            if(!anagrams.containsKey(anagram)) {
                anagrams.put(anagram, new ArrayList());
            }
            anagrams.get(anagram).add(originalString);
        }
        return new ArrayList(anagrams.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = groupAnagrams(strs);
        for(List<String> list : anagrams) {
            System.out.print(list);
        }
    }
}
