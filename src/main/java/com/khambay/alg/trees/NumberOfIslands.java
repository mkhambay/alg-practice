package com.khambay.alg.trees;

/**
 * Time and Space - O(r*c) r:row and c:column
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;

        int result = 0;
        for(int r = 0; r < rowLength; r++) {
            for(int c = 0; c < colLength; c++) {
                if(grid[r][c] == '1') {
                    result++; //island found
                    //claim it by setting all surrounding 1s to 0 till the first 0 in row or column
                    searchIslandsDFS(grid, r, c, rowLength, colLength);
                }
            }
        }
        return result;
    }

    public static void searchIslandsDFS(char[][] grid, int r, int c, int rowLength, int colLength) {
        //base case
        if(r < 0 || c < 0 || r >= rowLength || c >= colLength || grid[r][c] == '0') {
            return;
        }

        //set current grid position to Zero
        grid[r][c] = '0';
        searchIslandsDFS(grid, r - 1, c, rowLength, colLength);
        searchIslandsDFS(grid, r + 1, c, rowLength, colLength);
        searchIslandsDFS(grid, r, c - 1, rowLength, colLength);
        searchIslandsDFS(grid, r, c + 1, rowLength, colLength);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Number of islands = " + numIslands(grid));

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Number of islands grid1 = " + numIslands(grid1));
    }
}
