package ife.mp.lk.tests;

import ife.mp.lk.BacktrackingSudokuSolver;
import ife.mp.lk.SudokuBoard;
import ife.mp.lk.SudokuBoardsCache;
import ife.mp.lk.SudokuRow;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.*;

class SudokuRowTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    SudokuBoardsCache cache = new SudokuBoardsCache();
    private static final Logger logger = LoggerFactory.getLogger(SudokuRowTest.class);


    @Test
    void rowIsValidTest(){
        logger.atInfo().log("testing rowIsValidTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        assertTrue(sudokuRow.isValid());
    }


    @Test
    void SudokuRowIsNotValidTest(){
        logger.atInfo().log("testing SudokuRowIsNotValidTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        sudokuBoard.set(0,0,1);
        sudokuBoard.set(1,0,1);
        SudokuRow sudokuRow = sudokuBoard.getRow(0);

        assertFalse(sudokuRow.isValid());
    }

    @Test
    void SudokuRowsFieldEqual0Test(){
        logger.atInfo().log("testing SudokuRowsFieldEqual0Test");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        sudokuBoard.set(0,0,0);
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        assertFalse(sudokuRow.isValid());
    }

    @Test
    void SudokuRowTestUsingCheckBoard(){
        logger.atInfo().log("testing SudokuRowTestUsingCheckBoard");
        SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");

        sudokuBoard.set(0,0,1);
        sudokuBoard.set(0,1,2);
        sudokuBoard.set(0,2,3);
        sudokuBoard.set(0,3,4);
        sudokuBoard.set(0,4,5);
        sudokuBoard.set(0,5,6);
        sudokuBoard.set(0,6,7);
        sudokuBoard.set(0,7,8);
        sudokuBoard.set(0,8,9);

        sudokuBoard.set(1,0,4);
        sudokuBoard.set(1,1,6);
        sudokuBoard.set(1,2,5);
        sudokuBoard.set(1,3,7);
        sudokuBoard.set(1,4,8);
        sudokuBoard.set(1,5,9);
        sudokuBoard.set(1,6,1);
        sudokuBoard.set(1,7,2);
        sudokuBoard.set(1,8,3);

        sudokuBoard.set(2,0,7);
        sudokuBoard.set(2,1,8);
        sudokuBoard.set(2,2,9);
        sudokuBoard.set(2,3,1);
        sudokuBoard.set(2,4,2);
        sudokuBoard.set(2,5,3);
        sudokuBoard.set(2,6,4);
        sudokuBoard.set(2,7,5);
        sudokuBoard.set(2,8,6);

        sudokuBoard.set(3,0,2);
        sudokuBoard.set(3,1,3);
        sudokuBoard.set(3,2,4);
        sudokuBoard.set(3,3,5);
        sudokuBoard.set(3,4,6);
        sudokuBoard.set(3,5,7);
        sudokuBoard.set(3,6,8);
        sudokuBoard.set(3,7,9);
        sudokuBoard.set(3,8,1);

        sudokuBoard.set(4,0,5);
        sudokuBoard.set(4,1,6);
        sudokuBoard.set(4,2,7);
        sudokuBoard.set(4,3,8);
        sudokuBoard.set(4,4,9);
        sudokuBoard.set(4,5,1);
        sudokuBoard.set(4,6,2);
        sudokuBoard.set(4,7,3);
        sudokuBoard.set(4,8,4);

        sudokuBoard.set(5,0,8);
        sudokuBoard.set(5,1,9);
        sudokuBoard.set(5,2,1);
        sudokuBoard.set(5,3,2);
        sudokuBoard.set(5,4,3);
        sudokuBoard.set(5,5,4);
        sudokuBoard.set(5,6,5);
        sudokuBoard.set(5,7,6);
        sudokuBoard.set(5,8,7);

        sudokuBoard.set(6,0,3);
        sudokuBoard.set(6,1,4);
        sudokuBoard.set(6,2,5);
        sudokuBoard.set(6,3,6);
        sudokuBoard.set(6,4,7);
        sudokuBoard.set(6,5,8);
        sudokuBoard.set(6,6,9);
        sudokuBoard.set(6,7,1);
        sudokuBoard.set(6,8,2);

        sudokuBoard.set(7,0,6);
        sudokuBoard.set(7,1,7);
        sudokuBoard.set(7,2,8);
        sudokuBoard.set(7,3,9);
        sudokuBoard.set(7,4,1);
        sudokuBoard.set(7,5,2);
        sudokuBoard.set(7,6,3);
        sudokuBoard.set(7,7,4);
        sudokuBoard.set(7,8,5);

        sudokuBoard.set(8,0,9);
        sudokuBoard.set(8,1,1);
        sudokuBoard.set(8,2,2);
        sudokuBoard.set(8,3,3);
        sudokuBoard.set(8,4,4);
        sudokuBoard.set(8,5,5);
        sudokuBoard.set(8,6,6);
        sudokuBoard.set(8,7,7);
        sudokuBoard.set(8,8,8);


        assertFalse(sudokuBoard.checkBoard());

    }

    @Test
    void SudokuRowEqualsTest(){
        logger.atInfo().log("testing SudokuRowEqualsTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        SudokuRow sudokuRow2 = sudokuBoard.getRow(0);
        assertEquals(sudokuRow,sudokuRow2);
    }

    @Test
    void SudokuRowNotEqualsTest(){
        logger.atInfo().log("testing SudokuRowNotEqualsTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        SudokuRow sudokuRow2 = sudokuBoard.getRow(1);
        assertNotEquals(sudokuRow,sudokuRow2);
    }

    @Test
    void SudokuRowHashCodeTest(){
        logger.atInfo().log("testing SudokuRowHashCodeTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        SudokuRow sudokuRow2 = sudokuBoard.getRow(0);
        assertEquals(sudokuRow.hashCode(),sudokuRow2.hashCode());
    }

    @Test
    void SudokuRowToStringTest(){
        logger.atInfo().log("testing SudokuRowToStringTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        String expected = "1 2 3 4 5 6 7 8 9 ";
        assertNotEquals(expected,sudokuRow.toString());
    }

    @Test
    void CheckIfObjIsAnInstanceOfSudokuRow(){
        logger.atInfo().log("testing CheckIfObjIsAnInstanceOfSudokuRow");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        Object obj = new Object();
        boolean result = sudokuRow.equals(obj);
        assertFalse(result);
    }
}