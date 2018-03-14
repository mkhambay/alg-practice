package com.khambay.alg.strings;

import java.util.LinkedHashMap;

/**
 * Time and Space - O(n)
 */
public class FirstUniqueChar {

    static class CharCountandIndex {
        int index;
        int count;

        public CharCountandIndex(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Integer, CharCountandIndex> charMap = new LinkedHashMap<>();

        char[] charArray = s.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            int charVal = charArray[i];
            if(charMap.containsKey(charVal)) {
                CharCountandIndex countIndex = charMap.get(charVal);
                countIndex.count++;
                charMap.put(charVal, countIndex);
            }
            else {
                charMap.put(charVal, new CharCountandIndex(i, 1));
            }
        }

        int index = -1;
        for(Integer key : charMap.keySet()) {
            if(charMap.get(key).count == 1) {
                index = charMap.get(key).index;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        String test = new String("dddccdbba");
        System.out.println("First unique char = " + firstUniqChar(test));

        String test1 = new String("leetcode");
        System.out.println("First unique char = " + firstUniqChar(test1));
    }
}
