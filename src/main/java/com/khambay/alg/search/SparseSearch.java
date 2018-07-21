package com.khambay.alg.search;

/**
 * Time - O(n) - worst case with lot of empty strings. Best could be O(logn)??
 * Space - O(1)
 */
public class SparseSearch {

    public static int search(String[] strings, String str, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        mid = findNonEmptyMid(strings, mid, low, high);

        if (strings[mid].equals(str)) { // Found it!
            return mid;
        }
        else if (strings[mid].compareTo(str) < 0) { //Note: compareTo compares lexicographically
            //Search to the right
            return search(strings, str, mid + 1, high);
        }
        else {
            //Search to the left
            return search(strings, str, low, mid - 1);
        }
    }

    private static int findNonEmptyMid(String[] strings, int mid, int low, int high) {
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < low && right > high) {
                    return -1;
                }
                else if (right <= high && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }
                else if (left >= low && !strings[left].isEmpty()) {
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
