package com.khambay.alg.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }

        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];  //last index of each character

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }

        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i)-'a']);

            if(last == i) { //if index matches last index of character, its the result ex. a = 8, 8 - 0 + 1 = 9
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(str);
        System.out.println("Partitioned str = " + result);
    }
}
