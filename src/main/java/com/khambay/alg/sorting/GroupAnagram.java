package com.khambay.alg.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagram {

    public void groupAnagram(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            String sortedString = this.sortString(arr[i]);

            if(!map.containsKey(sortedString)) {
                ArrayList<String> strings = new ArrayList();
                strings.add(arr[i]);
                map.put(sortedString, strings);
            }
            else {
                ArrayList stringList = map.get(sortedString);
                stringList.add(arr[i]);
            }

            //Write map back to array
            int index = 0;
            for(String key : map.keySet()) {
                ArrayList<String> list = map.get(key);
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
