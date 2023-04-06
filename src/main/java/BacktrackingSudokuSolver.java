import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;


public class BacktrackingSudokuSolver implements SudokuSolver {

    public void solve(SudokuBoard board) {
        if (!solve(board, 0, 0)) {
            System.out.println("No solution");
        }
    }

    private boolean solve(SudokuBoard board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return solve(board, row + 1, 0);
        }
        if (board.get(row, col) != 0) {
            return solve(board, row, col + 1);
        }

        List<Integer> numbersToTry = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbersToTry);

        for (int i = 0; i < 9; i++) {
            if (isValid(board, row, col, numbersToTry.get(i))) {
                board.set(row, col, numbersToTry.get(i));
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board.set(row, col, 0);
            }
        }
        return false;
    }

    private boolean isValid(SudokuBoard board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board.get(row, i) == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board.get(i, col) == num) {
                return false;
            }
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.get(boxRow + i, boxCol + j) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
