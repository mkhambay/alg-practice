package com.khambay.alg.sorting;

public class SparseSearch {

    public static int search(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

        int mid = (last + first) / 2;
        mid = findNonEmptyMid(strings, mid, first, last);

        if (str.equals(strings[mid])) { // Found it!
            return mid;
        }
        else if (strings[mid].compareTo(str) < 0) { //Note: compareTo compares lexicographically
            //Search to the right
            return search(strings, str, mid + 1, last);
        }
        else {
            //Search to the left
            return search(strings, str, first, mid - 1);
        }
    }

    private static int findNonEmptyMid(String[] strings, int mid, int first, int last) {
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                }
                else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }
                else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        return mid;
    }

    public static int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }

    public static void main(String[] args) {
        String[] stringList = {"choco", "", "", "latte", "", "apple", "", "pumpkin", "", "", "rice", "", "", ""};
        System.out.println(search(stringList, "latte"));
    }
}
