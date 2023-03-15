import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testFillBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard();
    }
}