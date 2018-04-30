package com.khambay.alg.bit;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rowLength = board.length;
        int colLength = board[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int initialState = board[row][col];
                int lives = liveNeighbors(board, rowLength, colLength, row, col);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit should become 1.
                if (initialState == 1 && lives >= 2 && lives <= 3) {
                    board[row][col] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (initialState == 0 && lives == 3) {  
                    board[row][col] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        //Get the 2nd state, shift 1 bit right unsigned
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                board[row][col] >>= 1;
            }
        }
    }

    public static int liveNeighbors(int[][] board, int rowLength, int colLength, int row, int col) {
        int lives = 0;
        for (int r = Math.max(row - 1, 0); r <= Math.min(row + 1, rowLength - 1); r++) {
            for (int c = Math.max(col - 1, 0); c <= Math.min(col + 1, colLength - 1); c++) {
                lives += board[r][c] & 1;  //capture the value if its either 0 or 1 and add to lives
            }
        }
        lives -= board[row][col] & 1; //reduce the current r,c from the lives count incase it was 1
        return lives;
    }

    public static void main(String[] args) {
        int[][]board = {
                {1,0,0,0,0,0,0,0}, //1 - Any live cell with fewer than two live neighbors dies, as if caused by under-population
                {0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0}, //2 - Any live cell with two or three live neighbors lives on to the next generation
                {0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1}, //3 - Any live cell with more than three live neighbors dies, as if by over-population..
                {0,0,0,0,0,0,0,0},
                {0,1,1,1,0,0,0,0}, //4 - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                {0,0,0,0,0,0,0,0},
        };

        gameOfLife(board);
    }
}
