package com.khambay.alg.arrays;

public class ZeroMatrix {

    void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //Store all row/column with value 0
        for (int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //Nullify rows
        for (int i = 0; i < row.length; i++) {
            if(row[i]) {
                nullifyRow(matrix, i);
            }
        }

        //Nullify columns
        for (int j = 0; j < column.length; j++) {
            if(column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void main(String args[]) {
        int[][] matrix = {
                {4,5,0,7},
                {7,8,6,9},
                {0,1,2,10},
                {8,9,10,1}
        };

        ZeroMatrix zeroMatrix = new ZeroMatrix();
        zeroMatrix.setZeros(matrix);

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
}
