import java.util.*;

public class SudokuBoard {

    private Integer[][] board;

    public SudokuBoard() {
        board = new Integer[9][9];
    }

    public void PrintBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
                if (j == 2 || j == 5)
                    System.out.print("| ");
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.println("---------------------");
        }
    }
    public void fillBoard() {
        Random rand = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        //fill 15 random numbers
        for (int k = 0; k < 15; k++) {
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);
            int num = rand.nextInt(9) +1;
            board[i][j] = num;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
                if(j==2 || j==5)
                    System.out.print("| ");
            }
            System.out.println();
            if(i==2 || i==5)
                System.out.println("---------------------");
        }
        System.out.println();

        //fill the rest with the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int num = board[i][j];
                if (num == 0) {
                    for (int k = 0; k < 9; k++) {
                        if (validation(i, j, k) == true) {
                            board[i][j] = k;
                            break;
                        }
                    }
                }
            }
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
}