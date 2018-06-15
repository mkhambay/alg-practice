package com.khambay.alg.design;

/**
 * Time - 0(1)
 * Space - O(n)
 */
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col) {
            diagonal += toAdd;
        }

        if (col == (cols.length - 1 - row)) {
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antiDiagonal) == size) {
            return player;
        }

        return 0;
    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);

        toe.move(0, 0, 1); //-> Returns 0 (no one wins)
//X| | |
//| | | |    // Player 1 makes a move at (0, 0).
//| | | |

        toe.move(0, 2, 2); ////-> Returns 0 (no one wins)
//|X| |O|
//| | | |    // Player 2 makes a move at (0, 2).
//| | | |

        toe.move(2, 2, 1); //-> Returns 0 (no one wins)
//|X| |O|
//| | | |    // Player 1 makes a move at (2, 2).
//| | |X|

        toe.move(1, 1, 2); //-> Returns 0 (no one wins)
//|X| |O|
//| |O| |    // Player 2 makes a move at (1, 1).
//| | |X|

        toe.move(2, 0, 1); //-> Returns 0 (no one wins)
//|X| |O|
//| |O| |    // Player 1 makes a move at (2, 0).
//|X| |X|

        toe.move(1, 0, 2); //-> Returns 0 (no one wins)
//|X| |O|
//|O|O| |    // Player 2 makes a move at (1, 0).
//|X| |X|

        int win = toe.move(2, 1, 1); //-> Returns 1 (player 1 wins)
//|X| |O|
//|O|O| |    // Player 1 makes a move at (2, 1).
//|X|X|X|
        System.out.println("Player win = " + win);
    }
}
