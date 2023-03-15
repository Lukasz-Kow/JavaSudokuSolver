import java.util.*;

public class SudokuBoard {

    private Integer[][] board;

    public SudokuBoard() {
        board = new Integer[9][9];
        for (Integer[] fields : board) {
            Arrays.fill(fields, 0);
        }
    }

    public void fillBoard() {
        // Backtracking algorithm
        boolean isFull = true;

        for (Integer[] integers : board) {
            for (int j = 0; j < board.length; j++) {
                if (integers[j] == 0) {
                    isFull = false;
                    break;
                }
            }
        }

        if (!isFull) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        for (int k = 1; k <= 9; k++) {
                            if (validation(i, j, k)) {
                                board[i][j] = k;
                                fillBoard();
                                board[i][j] = 0;
                            }
                        }
                        return;
                    }
                }
            }
        } else {
            printBoard();
        }

    }

    private boolean validation(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRow + i][boxCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
                if(j == 2 || j == 5)
                    System.out.print("| ");
                }
                    System.out.println();
                if(i==2 || i==5)
                    System.out.println("---------------------");
            }
        System.out.println();
    }
}