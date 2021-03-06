package com.khambay.alg.arrays;

public class RotateMatrix {

    public static boolean rotate(int[][] matrix) {

        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false; // Not a square
        }

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer; //as we go inside each layer
            for(int i = first; i < last; i++) {
                int offset = i - first;

                //put top matrix[0][0] into temp
                int top = matrix[first][i]; // save top

                // left -> top
                // move matrix[3][0] -> matrix[0,0]
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                // move matrix[3][3] -> matrix[3][0]
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                // move matrix[0][3] -> matrix[3][3]
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                // move temp -> matrix[0][3]
                matrix[i][last] = top;
            }
        }
        return true;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = randomMatrix(4, 4, 0, 9);
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);
    }
}