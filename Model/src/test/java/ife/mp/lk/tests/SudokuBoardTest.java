package ife.mp.lk.tests;

import ife.mp.lk.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    SudokuTestValidatorHelper validator = new SudokuTestValidatorHelper();

    SudokuBoardsCache cache = new SudokuBoardsCache();
    private static final Logger logger = LoggerFactory.getLogger(SudokuBoardTest.class);


    @Test
    void solveEmptyBoard() {
        logger.atInfo().log("testing solveEmptyBoard");

        SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");

        sudokuBoard.solve();

        assertTrue(validator.isValid(sudokuBoard));

    }

    @Test
    void cannotSolveUnresolvableBoard() {
            logger.atInfo().log("testing cannotSolveUnresolvableBoard");
            SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");

            sudokuBoard.set(0, 0, 1);
            sudokuBoard.set(0, 1, 2);
            sudokuBoard.set(0, 2, 3);
            sudokuBoard.set(0, 3, 4);
            sudokuBoard.set(0, 4, 5);
            sudokuBoard.set(0, 5, 6);
            sudokuBoard.set(0, 6, 7);
            sudokuBoard.set(0, 7, 8);
            sudokuBoard.set(0, 8, 9);

            sudokuBoard.set(1, 0, 2);
            sudokuBoard.set(1, 1, 3);
            sudokuBoard.set(1, 2, 4);
            sudokuBoard.set(1, 3, 5);
            sudokuBoard.set(1, 4, 6);
            sudokuBoard.set(1, 5, 7);
            sudokuBoard.set(1, 6, 8);
            sudokuBoard.set(1, 7, 9);
            sudokuBoard.set(1, 8, 1);

            sudokuBoard.set(2, 0, 3);
            sudokuBoard.set(2, 1, 4);
            sudokuBoard.set(2, 2, 5);
            sudokuBoard.set(2, 3, 6);
            sudokuBoard.set(2, 4, 7);
            sudokuBoard.set(2, 5, 8);
            sudokuBoard.set(2, 6, 9);
            sudokuBoard.set(2, 7, 1);
            sudokuBoard.set(2, 8, 2);

            sudokuBoard.set(3, 0, 4);
            sudokuBoard.set(3, 1, 5);
            sudokuBoard.set(3, 2, 6);
            sudokuBoard.set(3, 3, 7);
            sudokuBoard.set(3, 4, 8);
            sudokuBoard.set(3, 5, 9);
            sudokuBoard.set(3, 6, 1);
            sudokuBoard.set(3, 7, 2);
            sudokuBoard.set(3, 8, 3);

            sudokuBoard.set(4, 0, 5);
            sudokuBoard.set(4, 1, 6);
            sudokuBoard.set(4, 2, 7);
            sudokuBoard.set(4, 3, 8);
            sudokuBoard.set(4, 4, 9);
            sudokuBoard.set(4, 5, 1);
            sudokuBoard.set(4, 6, 2);
            sudokuBoard.set(4, 7, 3);
            sudokuBoard.set(4, 8, 4);

            sudokuBoard.set(5, 0, 6);
            sudokuBoard.set(5, 1, 7);
            sudokuBoard.set(5, 2, 8);
            sudokuBoard.set(5, 3, 9);
            sudokuBoard.set(5, 4, 1);
            sudokuBoard.set(5, 5, 2);
            sudokuBoard.set(5, 6, 3);
            sudokuBoard.set(5, 7, 4);
            sudokuBoard.set(5, 8, 5);

            sudokuBoard.set(6, 0, 7);
            sudokuBoard.set(6, 1, 8);
            sudokuBoard.set(6, 2, 9);
            sudokuBoard.set(6, 3, 1);
            sudokuBoard.set(6, 4, 2);
            sudokuBoard.set(6, 5, 3);
            sudokuBoard.set(6, 6, 4);
            sudokuBoard.set(6, 7, 5);
            sudokuBoard.set(6, 8, 6);

            sudokuBoard.set(7, 0, 8);
            sudokuBoard.set(7, 1, 9);
            sudokuBoard.set(7, 2, 1);
            sudokuBoard.set(7, 3, 2);
            sudokuBoard.set(7, 4, 3);
            sudokuBoard.set(7, 5, 4);
            sudokuBoard.set(7, 6, 5);

            sudokuBoard.set(8, 0, 9);
            sudokuBoard.set(8, 1, 1);
            sudokuBoard.set(8, 2, 2);
            sudokuBoard.set(8, 3, 3);
            sudokuBoard.set(8, 4, 4);
            sudokuBoard.set(8, 5, 5);
            sudokuBoard.set(8, 6, 6);
            sudokuBoard.set(8, 7, 7);
            sudokuBoard.set(8, 8, 8);

            sudokuBoard.solve();

            assertFalse(validator.isValid(sudokuBoard));


    }

    @Test
    void test2SubsequentBoardsAreDifferent(){
        logger.atInfo().log("testing test2SubsequentBoardsAreDifferent");
        SudokuBoard sudokuBoard1 = cache.get("Solved Sudoku Board");

        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard2 = new SudokuBoard(solver);

        assertNotEquals(sudokuBoard1, sudokuBoard2);

    }

    @Test
    void printingBoardTest(){
        logger.atInfo().log("testing printingBoardTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        //sudokuBoard.printBoard();

        assertNotNull(sudokuBoard);

    }

    @Test
    void EmptyMainTest() throws Exception {
        logger.atInfo().log("testing EmptyMainTest");
        Main main = new Main();
        main.main(new String[0]);
    }

    @Test
    void IsValidTest(){
        logger.atInfo().log("testing IsValidTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        assertTrue(validator.isValid(sudokuBoard));
    }


    @Test
    void columnIsValidTest(){
        logger.atInfo().log("testing columnIsValidTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertTrue(sudokuColumn.isValid());
    }

    @Test
    void checkBoardTest(){
        logger.atInfo().log("testing checkBoardTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        //sudokuBoard.printBoard();
        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        assertTrue(sudokuBoard.checkBoard());
    }

    @Test
    void checkBoardTestNotValidBecauseOfRow(){
        logger.atInfo().log("testing checkBoardTestNotValidBecauseOfRow");
        SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuBoard.set(i,j, (i*3+j+1)%9+1);
            }
        }

        //sudokuBoard.printBoard();

        assertFalse(sudokuBoard.checkBoard());
    }

    @Test
    void checkBoardTestNotValidBecauseOfColumn(){
        logger.atInfo().log("testing checkBoardTestNotValidBecauseOfColumn");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        sudokuBoard.set(0,0,1);
        sudokuBoard.set(0,8,1);
        assertFalse(sudokuBoard.checkBoard());
    }

    @Test
    void CheckIfObjIsAnInstanceOfSudokuBoard(){
        logger.atInfo().log("testing CheckIfObjIsAnInstanceOfSudokuBoard");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        Object obj = new Object();
        boolean result = sudokuBoard.equals(obj);
        assertFalse(result);
    }

    @Test
    public void SudokuBoardEqualsSameObject() {
        logger.atInfo().log("testing SudokuBoardEqualsSameObject");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        assertTrue(sudokuBoard.equals(sudokuBoard));
    }
    @Test
    void SudokuBoardHashCodeTest(){
        logger.atInfo().log("testing SudokuBoardHashCodeTest");
        SudokuBoard sudokuBoard1 = cache.get("Solved Sudoku Board");
        SudokuBoard sudokuBoard2 = cache.get("Solved Sudoku Board");
        assertEquals(sudokuBoard1.hashCode(), sudokuBoard2.hashCode());
    }

    @Test
    void SudokuBoardToStringTest(){
        logger.atInfo().log("testing SudokuBoardToStringTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
        assertNotNull(sudokuBoard.toString());
    }

    @Test
    public void testRemoveFields() {
        logger.atInfo().log("testing testRemoveFields");
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.removeFields(40); // Remove 40 fields

        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard.get(i, j) == 0) {
                    count++;
                }
            }
        }

        assertEquals(40, count);
    }

}
