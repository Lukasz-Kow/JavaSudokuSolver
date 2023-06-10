package ife.mp.lk;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SudokuColumnTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    SudokuBoardsCache cache = new SudokuBoardsCache();

    @Test
    void printColumnTest(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        sudokuColumn.print();
        assertNotNull(sudokuColumn);
    }

    @Test
    void columnIsValidTest(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertTrue(sudokuColumn.isValid());
    }


    @Test
    void SudokuColumnIsNotValidTest(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        sudokuBoard.set(0,0,1);
        sudokuBoard.set(2,0,1);
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertFalse(sudokuColumn.isValid());
    }

    @Test
    void SudokuColumnsFieldEqual0Test(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        sudokuBoard.set(0,0,0);
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertFalse(sudokuColumn.isValid());
    }
//row test
    @Test
    void SudokuColumnTestUsingCheckBoard(){
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

        sudokuBoard.set(1,0,7);
        sudokuBoard.set(1,1,5);
        sudokuBoard.set(1,2,6);
        sudokuBoard.set(1,3,7);
        sudokuBoard.set(1,4,8);
        sudokuBoard.set(1,5,9);
        sudokuBoard.set(1,6,1);
        sudokuBoard.set(1,7,2);
        sudokuBoard.set(1,8,3);

        sudokuBoard.set(2,0,4);
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


        sudokuBoard.printBoard();
        assertFalse(sudokuBoard.checkBoard());

    }

    @Test
    void CheckIfObjIsAnInstanceOfSudokuColumn(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        Object obj = new Object();
        boolean result = sudokuColumn.equals(obj);
        assertFalse(result);
    }

    @Test
    void SudokuColumnEqualsTest(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        SudokuColumn sudokuColumn2 = sudokuBoard.getColumn(0);
        assertEquals(sudokuColumn,sudokuColumn2);
    }

    @Test
    void SudokuColumnNotEqualsTest(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        SudokuColumn sudokuColumn2 = sudokuBoard.getColumn(1);
        assertNotEquals(sudokuColumn,sudokuColumn2);
    }

    @Test
    void SudokuColumnHashCodeTest(){
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBoard sudokuBoard2 = cache.get("Solved Sudoku Board");

        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        SudokuColumn sudokuColumn2 = sudokuBoard.getColumn(1);

        assertNotEquals(sudokuColumn.hashCode(),sudokuColumn2.hashCode());
    }


}