package com.khambay.alg.bfs;

/**
 * Time - O(r*c)
 * Space - O(1)
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (exist(board, row, col, charArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int row, int col, char[] word, int length) {
        if (length == word.length) {
            return true;
        }

        if (row < 0 || col < 0 || row == board.length || col == board[row].length) {
            return false;
        }

        if (board[row][col] != word[length]) {
            return false;
        }

        //board[y][x] ^= 256 it's a marker that the letter at position x,y is a part of word we search.
        //After board[y][x] ^= 256 the char became not a valid letter. After second board[y][x] ^= 256
        //it became a valid letter again.
        board[row][col] ^= 256; //mask - marks visited

        boolean exist =    exist(board, row, col+1, word, length+1)
                        || exist(board, row, col-1, word, length+1)
                        || exist(board, row+1, col, word, length+1)
                        || exist(board, row-1, col, word, length+1);

        board[row][col] ^= 256; //unmask - marks unvisited

        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println("ABCCED = " + exist(board, "ABCCED"));
        System.out.println("SEE = " + exist(board, "SEE"));
        System.out.println("ABCB = " + exist(board, "ABCB"));
    }
}
