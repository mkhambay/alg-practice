package com.khambay.alg.heap;

import java.util.PriorityQueue;

/**
 * Time - O(n + klogn)
 * Build a min heap which takes O(n) time
 * Heapify k times which takes O(klogn) time
 * Space - O(n) for the heap
 */
public class KthSmallestSortedMatrixMinHeap {

    public static int kthSmallest(int[][] matrix, int k) {
        int rowLength = matrix.length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for(int j = 0; j <= rowLength - 1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j])); //added in order of the comparator below
        }

        for(int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll(); //gets top element in heap, the minimum

            if(t.row == rowLength - 1) { //row length reached
                continue;
            }
            pq.offer(new Tuple(t.row + 1, t.col, matrix[t.row + 1][t.col])); //add next row, same column
        }
        return pq.poll().val; //returns the top of the heap, the smallest value
    }

    static class Tuple implements Comparable<Tuple> {
        int row, col, val;

        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            System.out.println("Compare to" + that.val);
            return this.val - that.val;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println("Kth Smallest =" + kthSmallest(matrix, 8));
    }
}
