import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {

    public void solve(SudokuBoard board) {
        if (solve(board, 0, 0)) {
            System.out.println("Solved");
        } else {
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
        if (board.getValue(row, col) != 0) {
            return solve(board, row, col + 1);
        }
        for (int i = 1; i <= 9; i++) {
            int randomNum = new Random().nextInt(9) + 1;
            if (isValid(board, row, col, randomNum)) {
                board.setValue(row, col, randomNum);
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board.setValue(row, col, 0);
            }
        }
        return false;
    }

    private boolean isValid(SudokuBoard board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board.getValue(row, i) == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board.getValue(i, col) == num) {
                return false;
            }
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getValue(boxRow + i, boxCol + j) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
