package com.khambay.alg.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Time - O(rxc)
 * Space - O(1)
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col= 0; col < board[0].length; col++) {
                char number = board[row][col];

                if (number != '.') {
                    if (!seen.add(number + " in row " + row) ||
                            !seen.add(number + " in column " + col) ||
                            !seen.add(number + " in block " + row / 3 + "-" + col / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
              {'5','3','.','.','7','.','.','.','.'},
              {'6','.','.','1','9','5','.','.','.'},
              {'.','9','8','.','.','.','.','6','.'},
              {'8','.','.','.','6','.','.','.','3'},
              {'4','.','.','8','.','3','.','.','1'},
              {'7','.','.','.','2','.','.','.','6'},
              {'.','6','.','.','.','.','2','8','.'},
              {'.','.','.','4','1','9','.','.','5'},
              {'.','.','.','.','8','.','.','7','9'}
              };

        char[][] boardNotValid = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Is Valid = " + isValidSudoku(board));
        System.out.println("Is Valid = " + isValidSudoku(boardNotValid));
    }
}
