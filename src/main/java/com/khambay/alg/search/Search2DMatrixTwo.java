package com.khambay.alg.search;

/**
 * Time - O(mn)
 * Space - O(1)
 */
public class Search2DMatrixTwo {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;

        while(col >= 0 && row < matrix.length) {
            if(target == matrix[row][col]) {
                return true; //found it
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println("Search 5 should be true : result = " + searchMatrix(matrix, 5));
        System.out.println("Search 20 should be false : result = " + searchMatrix(matrix, 20));
    }
}
