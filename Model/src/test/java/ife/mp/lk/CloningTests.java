package ife.mp.lk;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CloningTests {

    @Test
    public void CreatingEmptySudokuBoardTest() {
        SudokuBoardsCache cache = new SudokuBoardsCache();
        SudokuBoard sudokuBoard2 = cache.get("Empty Sudoku Board");

        int sumOfBoard = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0 ; j < 9; j++) {
                sumOfBoard += sudokuBoard2.get(i, j);
            }
        }

        assertEquals(0, sumOfBoard);
    }

    @Test
    public void CreatingSolvedSudokuBoardTest() {
        SudokuBoardsCache cache = new SudokuBoardsCache();
        SudokuBoard sudokuBoard2 = cache.get("Solved Sudoku Board");

        int sumOfBoard = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sumOfBoard += sudokuBoard2.get(i, j);
            }
        }

        assertNotEquals(0, sumOfBoard);
    }

}
