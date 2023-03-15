import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

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
    void testFillBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard(0,0);
        sudokuBoard.printBoard();

        assertTrue(isValid(sudokuBoard));

    }

    @Test
    void test2SubsequentBoardsAreDifferent(){
        SudokuBoard sudokuBoard1 = new SudokuBoard();
        sudokuBoard1.fillBoard(0,0);
        SudokuBoard sudokuBoard2 = new SudokuBoard();
        sudokuBoard2.fillBoard(0,0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!Objects.equals(sudokuBoard1.getValue(i, j), sudokuBoard2.getValue(i, j))) {
                    assertTrue(true);
                }
            }
        }

    }
}