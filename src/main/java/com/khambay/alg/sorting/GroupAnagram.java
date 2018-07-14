package com.khambay.alg.sorting;

import java.util.*;

/**
 * Time - O(nlogn) - Arrays.sort
 * Space - O(n)
 */
public class GroupAnagram {

    public void groupAnagram(String[] arr) {

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            String sortedString = this.sortString(arr[i]);

            if(!map.containsKey(sortedString)) {
                List<String> strings = new ArrayList<>();
                strings.add(arr[i]);
                map.put(sortedString, strings);
            }
            else {
                List stringList = map.get(sortedString);
                stringList.add(arr[i]);
            }

            //Write map back to array
            int index = 0;
            for(String key : map.keySet()) {
                List<String> list = map.get(key);
                for(String str : list) {
                    arr[index] = str;
                    index++;
                }
            }
        }
    }

    private String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        String[] arr = {"cinema", "blah", "iceman", "halb", "aaa"};
        groupAnagram.groupAnagram(arr);

        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }
}
