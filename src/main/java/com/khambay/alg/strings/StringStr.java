package com.khambay.alg.strings;

/**
 * Time - O(mn)
 * Space - O(1)
 */
public class StringStr {

    public static int strStr1(String haystack, String needle) {
        if(needle == null || needle.length() < 1) { //when needle is empty, return starting index 0 and not -1
            return 0;
        }

        if(haystack == null || haystack.length() < 1) {
            return -1;
        }

        for (int i = 0; i <= haystack.length(); i++) { //haystack
            for (int j = 0; j <= needle.length() ; j++) { //needle
                if (j == needle.length()) { //match found
                    return i;
                }
                if (i + j == haystack.length()) { //boundry check
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) { //till we find the first matching char in haystack
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String one = "hello";
        String two = "ll";
        System.out.println("Index =" + strStr1(one, two));

        System.out.println("haystack = \"aaaaa\", needle = \"bba\"" + strStr1("aaaaa", "bba"));
    }
}
