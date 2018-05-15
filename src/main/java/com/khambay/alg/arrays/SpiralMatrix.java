package com.khambay.alg.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Time - O(mn)
 * Space - O(n) - new List
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int left = 0;
        int top = 0;
        int right = columnLength - 1;
        int bottom = rowLength - 1;

        while(result.size() < rowLength * columnLength) {

            //left -> right
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //prevent duplicate row
            if(top > bottom) {
                break;
            }

            //top -> bottom
            for(int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;

            //right -> left
            for(int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            if(left > right) {
                break;
            }

            //bottom -> top
            for(int j = bottom; j >= top; j--) {
                result.add(matrix[j][left]);
            }
            left++;
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        String[] rows = new String[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                row.append(matrix[i][j]);
                if(j + 1 != matrix.length) {
                    row.append(", ");
                }
            }
            rows[i] = row.toString();
        }

        for(int j = 0; j < rows.length; j++) {
            System.out.println("Row [" + j + "] = " + rows[j]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);

        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.print("[");
        for(int i = 0; i < spiralOrder.size()-1; i++) {
            System.out.print(spiralOrder.get(i) + ",");
        }
        System.out.println(spiralOrder.get(spiralOrder.size()-1) + "]");
    }
}
