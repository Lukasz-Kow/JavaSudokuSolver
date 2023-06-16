package ife.mp.lk;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CloningTests {

    private static final Logger logger = LoggerFactory.getLogger(CloningTests.class);

    @Test
    public void CreatingEmptySudokuBoardTest() {
        logger.atInfo().log("testing CreatingEmptySudokuBoardTest");
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
        logger.atInfo().log("testing CreatingSolvedSudokuBoardTest");
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
