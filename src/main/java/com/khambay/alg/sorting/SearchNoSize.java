package com.khambay.alg.sorting;

/**
 * Time - O(logn)
 * Space - O(1)
 */
public class SearchNoSize {

    static class Listy {
        int[] array;

        public Listy(int[] arr) {
            array = arr.clone();
        }

        public int elementAt(int index) {
            if (index >= array.length) {
                return -1;
            }
            return array[index];
        }
    }

    public static int search(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 //List not empty
                && list.elementAt(index) < value) {
            index *= 2;  //Go out 2^2 exponential time as we don't know the length of list
        }
        int low = index/2; //note - low does not start at 1
        int high = index; //presumed list length

        return binarySearch(list, value, low, high);
    }

    public static int binarySearch(Listy list, int value, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        if(list.elementAt(mid) < value) {
            return binarySearch(list, value, mid +1, high);
        }
        else if(list.elementAt(mid) > value) {
            return binarySearch(list, value, low, mid - 1);
        }
        else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);

        System.out.println("Search Recursive");
        for (int a : array) {
            System.out.println(search(list, a));
        }
        System.out.println(search(list, 15));
    }
}
