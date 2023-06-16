package ife.mp.lk;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoxTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    SudokuBoardsCache cache = new SudokuBoardsCache();
    private static final Logger logger = LoggerFactory.getLogger(SudokuBoxTest.class);


    @Test
    void printBoxTest(){
        logger.atInfo().log("testing printBoxTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        sudokuBox.print();
        assertNotNull(sudokuBox);
    }


    @Test
    void BoxIsValidTest(){
        logger.atInfo().log("testing BoxIsValidTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        assertTrue(sudokuBox.isValid());
    }


    @Test
    void SudokuBoxIsNotValidTest(){
        logger.atInfo().log("testing SudokuBoxIsNotValidTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        sudokuBoard.set(0,0,1);
        sudokuBoard.set(0,1,1);
        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        assertFalse(sudokuBox.isValid());
    }


    @Test
    void SudokuBoxsFieldEqual0Test(){
        logger.atInfo().log("testing SudokuBoxsFieldEqual0Test");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        sudokuBoard.set(0,0,0);
        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        assertFalse(sudokuBox.isValid());
    }

    @Test
    public void testEqualsWithDifferentClass() {
        logger.atInfo().log("testing testEqualsWithDifferentClass");
        SudokuField field = new SudokuField(5);
        Integer other;
        other = 5;
        assertFalse(field.equals(other));
    }

    @Test
    public void SudokuFieldtestEquals() {
        logger.atInfo().log("testing SudokuFieldtestEquals");
        SudokuField field1 = new SudokuField(1);
        SudokuField field2 = new SudokuField(1);
        SudokuField field3 = new SudokuField(2);

        assertTrue(field1.equals(field1));

        assertTrue(field1.equals(field2));
        assertTrue(field2.equals(field1));
        assertFalse(field1.equals(field3));
        assertFalse(field3.equals(field1));
    }
    @Test
    void SudokuBoxTestUsingCheckBoard(){
        logger.atInfo().log("testing SudokuBoxTestUsingCheckBoard");
        SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");


        sudokuBoard.set(0,0,1);
        sudokuBoard.set(0,1,1);
        sudokuBoard.set(0,2,3);
        sudokuBoard.set(0,3,4);
        sudokuBoard.set(0,4,5);
        sudokuBoard.set(0,5,6);
        sudokuBoard.set(0,6,7);
        sudokuBoard.set(0,7,8);
        sudokuBoard.set(0,8,9);

        sudokuBoard.set(1,0,4);
        sudokuBoard.set(1,1,5);
        sudokuBoard.set(1,2,6);
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
    void SudokuBoxEqualsTest(){
        logger.atInfo().log("testing SudokuBoxEqualsTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        SudokuBox sudokuBox2 = sudokuBoard.getBox(0);
        assertEquals(sudokuBox,sudokuBox2);
    }

    @Test
    void CheckIfObjIsAnInstanceOfSudokuBox(){
        logger.atInfo().log("testing CheckIfObjIsAnInstanceOfSudokuBox");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        Object obj = new Object();
        boolean result = sudokuBox.equals(obj);
        assertFalse(result);
    }

    @Test
    void SudokuBoxNotEqualsTest(){
        logger.atInfo().log("testing SudokuBoxNotEqualsTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        SudokuBox sudokuBox2 = sudokuBoard.getBox(1);
        assertNotEquals(sudokuBox,sudokuBox2);
    }

    @Test
    void SudokuBoxHashCodeTest(){
        logger.atInfo().log("testing SudokuBoxHashCodeTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        SudokuBox sudokuBox2 = sudokuBoard.getBox(0);
        assertEquals(sudokuBox.hashCode(),sudokuBox2.hashCode());
    }

    @Test
    void SudokuBoxToStringTest(){
        logger.atInfo().log("testing SudokuBoxToStringTest");
        SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");

        SudokuBox sudokuBox = sudokuBoard.getBox(0);
        String expected = "1 2 3 4 5 6 7 8 9 ";
        assertNotEquals(expected,sudokuBox.toString());
    }

    @Test
    void SudokuBoxMoreElementsTest(){
        logger.atInfo().log("testing SudokuBoxMoreElementsTest");
        List<SudokuField> testList = Arrays.asList(new SudokuField[10]);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            SudokuBox box = new SudokuBox(testList);
        });

        String expectedMessage = "Value must be between 1 and 9";
        String actualMessage = e.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}