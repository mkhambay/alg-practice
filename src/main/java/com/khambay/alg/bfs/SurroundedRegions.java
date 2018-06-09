package com.khambay.alg.bfs;

/**
 * Time and Space - O(r*c) r:row and c:column
 */
public class SurroundedRegions {

    public static void solve(char[][] board) {

        if(board == null || board.length == 0) {
            return;
        }

        int rowLength = board.length;
        int colLength = board[0].length;

        //check first and last col
        for(int i = 0; i < rowLength; i++){
            if(board[i][0] == 'O') {
                markZerosConnectedToBoundry(board,i,1);
            }

            if(board[i][colLength-1] == 'O') {
                markZerosConnectedToBoundry(board,i,colLength-2);
            }
        }

        //check first and last row
        for(int i = 0; i < colLength; i++){
            if(board[0][i] == 'O') {
                markZerosConnectedToBoundry(board,1,i);
            }
            if(board[rowLength-1][i] == 'O') {
                markZerosConnectedToBoundry(board,rowLength-2,i);
            }
        }

        //Switch all 'O's to 'X's and 'Y's to 'O's
        for(int i = 1; i < rowLength - 1; i++) {
            for(int j = 1; j < colLength - 1; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';  //switch back to O (not surrounded completely by 'X')
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X'; //'O' that is not on the border and it is not connected to an 'O'
                }
            }
        }
    }

    public static void markZerosConnectedToBoundry(char[][] board, int row, int col) {
        if(row >= board.length - 1 || row <= 0 || col >= board[0].length - 1 || col <= 0) { //if row/col boundry, return
            return;
        }

        if(board[row][col]=='X' || board[row][col]=='Y') { //leave it as is
            return;
        }

        if(board[row][col]=='O') {
            board[row][col]='Y'; //all the O's that are not surrounded completely by 'X' are switched to 'Y's
        }

        markZerosConnectedToBoundry(board,row+1,col);
        markZerosConnectedToBoundry(board,row-1,col);
        markZerosConnectedToBoundry(board,row,col+1);
        markZerosConnectedToBoundry(board,row,col-1);
    }

    public static void printGrid(char[][] board) {
        for(int r = 0; r < board.length; r++) {
            System.out.print("{");
            for(int c = 0; c < board[0].length; c++) {
                System.out.print("'" + board[r][c] + "'");
            }
            System.out.println("},");
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        printGrid(board);
        solve(board);
        System.out.println("Result=");
        printGrid(board);
    }
}
