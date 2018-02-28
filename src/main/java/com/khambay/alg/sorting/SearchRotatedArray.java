package com.khambay.alg.sorting;

public class SearchRotatedArray {

    public static int search(int a[], int x) {
        return search(a, 0, a.length - 1, x);
    }


    public static int search(int a[], int left, int right, int x) {
        //Get mid
        int mid = (left + right)/2;

        //Check mid match
        if (x == a[mid]) {
            return mid;
        }

        //End Recursive
        if (right < left) {
            return -1;
        }

        //Left side of mid is ordered
        if (a[left] < a[mid]) {
            //If search string between left and mid
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            }
            else {
                //Search right of mid
                return search(a, mid + 1, right, x);
            }
        }

        //Right side of mid is ordered
        else if (a[left] > a[mid]) {
            //If search string between mid and right
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            }
            else {
                //Search left of mid
                return search(a, left, mid - 1, x);
            }
        }

        //Edge case
        else if (a[left] == a[mid]) {
            if (a[mid] != a[right]) {
                //Search right
                return search(a, mid + 1, right, x);
            }
            else {
                //Search both sides - O(n)
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    //Not found on left, now search right
                    return search(a, mid + 1, right, x);
                }
                else {
                    //Found return result
                    return result;
                }
            }
        }
        //Not found
        return -1;
    }

    public static void printArray(int arr[]) {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    public static void main(String[] args) {
        int[] a = { 2, 2, 2, 3, 4, 2};

        printArray(a);
        System.out.println("Search 1 index = " + search(a, 1));
        System.out.println("Search 4 index = " + search(a, 4));
        System.out.println("Search 2 index = " + search(a, 2));

        int[] b = {10, 15, 20, 0, 5};
        printArray(b);
        System.out.println("Search 5 index = " + search(b, 5));

        int[] c = {50, 5, 20, 30, 40};
        printArray(c);
        System.out.println("Search 5 index = " + search(c, 5));
    }
}
