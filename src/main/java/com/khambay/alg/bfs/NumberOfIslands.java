package com.khambay.alg.bfs;

/**
 * Time and Space - O(r*c) r:row and c:column
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    result++; //island found
                    //claim it by setting all surrounding 1s to 0 till the first 0 in row or column
                    searchIslandsDFS(grid, r, c);
                }
            }
        }
        return result;
    }

    public static void searchIslandsDFS(char[][] grid, int r, int c) {
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        //set current grid position to Zero
        grid[r][c] = '0';

        searchIslandsDFS(grid, r - 1, c);
        searchIslandsDFS(grid, r + 1, c);
        searchIslandsDFS(grid, r, c - 1);
        searchIslandsDFS(grid, r, c + 1);
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
