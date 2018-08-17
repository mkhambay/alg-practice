package com.khambay.alg.strings;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class StringUrlify {

    public void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength, i;

        //Get space count
        for(i = 0; i < length; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;
        str[newLength] = '\0';
        for(i = length - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
    }


    public static void main(String[] args) {
        StringUrlify stringUrlify = new StringUrlify();
        String url = "Mr John Smith     ";

        System.out.println("url size=" + url.length());
        char[] array = url.toCharArray();

        stringUrlify.replaceSpaces(array, 13);

        String urlified = new String(array);

        System.out.println("url urlified = " + urlified + " with size=" + urlified.length());
    }
}
