package com.khambay.alg.strings;

/**
 * Time - O(mn)
 * Space - O(1)
 */
public class StringStr {

    public static int strStr1(String haystack, String needle) {
        if(haystack==null || needle==null)
            return 0;

        if(needle.length() == 0)
            return 0;

        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
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
    }

    public static void main(String[] args) {
        String one = "hello";
        String two = "ll";
        System.out.println("Index =" + strStr1(one, two));

        System.out.println("haystack = \"aaaaa\", needle = \"bba\"" + strStr1("aaaaa", "bba"));
    }
}
