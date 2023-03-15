import java.util.*;

public class SudokuBoard {

    private Integer[][] board;

    public SudokuBoard() {
        board = new Integer[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public Integer[][] getBoard() {
        return board;
    }

    public Integer getValue (int row, int column) {
        return board[row][column];
    }

    public boolean fillBoard(int row, int column)
    {
        if(row == 8 && column == 9)
            return true;

        if(column == 9) {
            row++;
            column = 0;
        }


        for(int i = 0; i < 10; i++) {

            // Using a random number generator to fill the board
            // Not optimal but it works
            // TODO: Implement something with an array that is randomized everry time and iterate through it
            int randomNumber = new Random().nextInt(9) + 1;

            if(isValid(row, column, randomNumber))
            {
                board[row][column] = randomNumber;

                if(fillBoard(row, column + 1))
                {
                    return true;
                }
                else
                {
                    board[row][column] = 0;
                }
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int num) {
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