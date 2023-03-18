import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
    boolean isValid(SudokuBoard sudokuBoard) {

        // Check rows
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[10];
            for (int col = 0; col < 9; col++) {
                int num = sudokuBoard.getValue(row, col);
                if (num != 0) {
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        // Check columns
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[10];
            for (int row = 0; row < 9; row++) {
                int num = sudokuBoard.getValue(row, col);
                if (num != 0) {
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        // Check 3x3 squares
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] seen = new boolean[10];
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        int num = sudokuBoard.getValue(row, col);
                        if (num != 0) {
                            if (seen[num]) {
                                return false;
                            }
                            seen[num] = true;
                        }
                    }
                }
            }
        }

        // If all checks pass, the Sudoku board is valid
        return true;
    }

    @Test
    void solveEmptyBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard(solver);

        sudokuBoard.solve();

        assertTrue(isValid(sudokuBoard));

    }

    @Test
    void test2SubsequentBoardsAreDifferent(){
        SudokuBoard sudokuBoard1 = new SudokuBoard(solver);
        sudokuBoard1.solve();

        SudokuBoard sudokuBoard2 = new SudokuBoard(solver);
        sudokuBoard2.solve();

        assertNotEquals(sudokuBoard1, sudokuBoard2);

    }
}