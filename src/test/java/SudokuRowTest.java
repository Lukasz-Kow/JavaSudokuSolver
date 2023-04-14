import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SudokuRowTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();


    @Test
    void printRowTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        sudokuRow.print();
        assertNotNull(sudokuRow);
    }


    @Test
    void rowIsValidTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        assertTrue(sudokuRow.isValid());
    }


    @Test
    void SudokuRowIsNotValidTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.set(0,0,1);
        sudokuBoard.set(1,0,1);
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        sudokuRow.print();

        assertFalse(sudokuRow.isValid());
    }

    @Test
    void SudokuRowsFieldEqual0Test(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.set(0,0,0);
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        assertFalse(sudokuRow.isValid());
    }

    @Test
    void SudokuRowTestUsingCheckBoard(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);

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


        sudokuBoard.printBoard();
        assertFalse(sudokuBoard.checkBoard());

    }

    @Test
    void SudokuRowEqualsTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        SudokuRow sudokuRow2 = sudokuBoard.getRow(0);
        assertEquals(sudokuRow,sudokuRow2);
    }

    @Test
    void SudokuRowNotEqualsTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        SudokuRow sudokuRow2 = sudokuBoard.getRow(1);
        assertNotEquals(sudokuRow,sudokuRow2);
    }

    @Test
    void SudokuRowHashCodeTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        SudokuRow sudokuRow2 = sudokuBoard.getRow(0);
        assertEquals(sudokuRow.hashCode(),sudokuRow2.hashCode());
    }

    @Test
    void SudokuRowToStringTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        String expected = "1 2 3 4 5 6 7 8 9 ";
        assertNotEquals(expected,sudokuRow.toString());
    }

    @Test
    void CheckIfObjIsAnInstanceOfSudokuRow(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        Object obj = new Object();
        boolean result = sudokuRow.equals(obj);
        assertFalse(result);
    }
}