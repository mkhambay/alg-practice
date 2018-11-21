package com.khambay.alg.stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/discuss/29064/A-O(n2)-solution-based-on-Largest-Rectangle-in-Histogram
 * Time - O(n^2)
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array
        int[] height = new int[cLen+1]; //note its length + 1
        int max = 0;

        for (int row = 0 ;row < rLen; row++) {
            Stack<Integer> s = new Stack<>();

            for (int col = 0; col < cLen+1; col++) { //cLen+1
                if (col < cLen) {
                    if (matrix[row][col] == '1') {
                        height[col] += 1;
                    } else {
                        height[col] = 0;
                    }
                }

                while(!s.isEmpty() && height[col] < height[s.peek()]) {
                    int top = s.pop();
                    int width = !s.isEmpty() ? col - s.peek()-1 : col;
                    int area = height[top] * width;
                    max = Math.max(max, area);
                }

                s.push(col);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("Result = " + maximalRectangle(matrix));
    
    }
}
