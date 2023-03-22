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
    void cannotSolveUnresolvableBoard() {

            SudokuBoard sudokuBoard = new SudokuBoard(solver);

            sudokuBoard.setValue(0, 0, 1);
            sudokuBoard.setValue(0, 1, 2);
            sudokuBoard.setValue(0, 2, 3);
            sudokuBoard.setValue(0, 3, 4);
            sudokuBoard.setValue(0, 4, 5);
            sudokuBoard.setValue(0, 5, 6);
            sudokuBoard.setValue(0, 6, 7);
            sudokuBoard.setValue(0, 7, 8);
            sudokuBoard.setValue(0, 8, 9);

            sudokuBoard.setValue(1, 0, 2);
            sudokuBoard.setValue(1, 1, 3);
            sudokuBoard.setValue(1, 2, 4);
            sudokuBoard.setValue(1, 3, 5);
            sudokuBoard.setValue(1, 4, 6);
            sudokuBoard.setValue(1, 5, 7);
            sudokuBoard.setValue(1, 6, 8);
            sudokuBoard.setValue(1, 7, 9);
            sudokuBoard.setValue(1, 8, 1);

            sudokuBoard.setValue(2, 0, 3);
            sudokuBoard.setValue(2, 1, 4);
            sudokuBoard.setValue(2, 2, 5);
            sudokuBoard.setValue(2, 3, 6);
            sudokuBoard.setValue(2, 4, 7);
            sudokuBoard.setValue(2, 5, 8);
            sudokuBoard.setValue(2, 6, 9);
            sudokuBoard.setValue(2, 7, 1);
            sudokuBoard.setValue(2, 8, 2);

            sudokuBoard.setValue(3, 0, 4);
            sudokuBoard.setValue(3, 1, 5);
            sudokuBoard.setValue(3, 2, 6);
            sudokuBoard.setValue(3, 3, 7);
            sudokuBoard.setValue(3, 4, 8);
            sudokuBoard.setValue(3, 5, 9);
            sudokuBoard.setValue(3, 6, 1);
            sudokuBoard.setValue(3, 7, 2);
            sudokuBoard.setValue(3, 8, 3);

            sudokuBoard.setValue(4, 0, 5);
            sudokuBoard.setValue(4, 1, 6);
            sudokuBoard.setValue(4, 2, 7);
            sudokuBoard.setValue(4, 3, 8);
            sudokuBoard.setValue(4, 4, 9);
            sudokuBoard.setValue(4, 5, 1);
            sudokuBoard.setValue(4, 6, 2);
            sudokuBoard.setValue(4, 7, 3);
            sudokuBoard.setValue(4, 8, 4);

            sudokuBoard.setValue(5, 0, 6);
            sudokuBoard.setValue(5, 1, 7);
            sudokuBoard.setValue(5, 2, 8);
            sudokuBoard.setValue(5, 3, 9);
            sudokuBoard.setValue(5, 4, 1);
            sudokuBoard.setValue(5, 5, 2);
            sudokuBoard.setValue(5, 6, 3);
            sudokuBoard.setValue(5, 7, 4);
            sudokuBoard.setValue(5, 8, 5);

            sudokuBoard.setValue(6, 0, 7);
            sudokuBoard.setValue(6, 1, 8);
            sudokuBoard.setValue(6, 2, 9);
            sudokuBoard.setValue(6, 3, 1);
            sudokuBoard.setValue(6, 4, 2);
            sudokuBoard.setValue(6, 5, 3);
            sudokuBoard.setValue(6, 6, 4);
            sudokuBoard.setValue(6, 7, 5);
            sudokuBoard.setValue(6, 8, 6);

            sudokuBoard.setValue(7, 0, 8);
            sudokuBoard.setValue(7, 1, 9);
            sudokuBoard.setValue(7, 2, 1);
            sudokuBoard.setValue(7, 3, 2);
            sudokuBoard.setValue(7, 4, 3);
            sudokuBoard.setValue(7, 5, 4);
            sudokuBoard.setValue(7, 6, 5);

            sudokuBoard.setValue(8, 0, 9);
            sudokuBoard.setValue(8, 1, 1);
            sudokuBoard.setValue(8, 2, 2);
            sudokuBoard.setValue(8, 3, 3);
            sudokuBoard.setValue(8, 4, 4);
            sudokuBoard.setValue(8, 5, 5);
            sudokuBoard.setValue(8, 6, 6);
            sudokuBoard.setValue(8, 7, 7);
            sudokuBoard.setValue(8, 8, 8);

            sudokuBoard.solve();

            assertFalse(isValid(sudokuBoard));


    }

    @Test
    void test2SubsequentBoardsAreDifferent(){
        SudokuBoard sudokuBoard1 = new SudokuBoard(solver);
        sudokuBoard1.solve();

        SudokuBoard sudokuBoard2 = new SudokuBoard(solver);
        sudokuBoard2.solve();

        assertNotEquals(sudokuBoard1, sudokuBoard2);

    }

    @Test
    void printingBoardTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.printBoard();

        assertNotNull(sudokuBoard);


    }

    @Test
    void EmptyMainTest(){
        Main main = new Main();
        main.main(new String[0]);


    }
}