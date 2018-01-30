package com.khambay.alg.arrays;

public class SortEvenAndOdd {

  
  public void evenOdd(int[] A) {
    int nextEven = 0, nextOdd = A.length -1;
    while(nextEven < nextOdd) {
      if(A[nextEven] % 2 == 0) {
        nextEven++;
      }
      else {
        int temp = A[nextEven];
        A[nextEven] = A[nextOdd];
        A[nextOdd--] = temp;
      }
    }
  }
  
  public void printArray(int[] A) {
    for(int i = 0; i < A.length; i++) {
      System.out.println("Index=" + i + "value=" + A[i]);
    }
  }
  
  public static void main(String args[]) {
    SortEvenAndOdd sort = new SortEvenAndOdd();
    int[] unsorted = new int[] {1,5,3,2,8,1,11,4,9,18};
    System.out.println("Printing unsorted");
    sort.printArray(unsorted);
    sort.evenOdd(unsorted);
    System.out.println("Printing sorted");
    sort.printArray(unsorted);
  }
}
