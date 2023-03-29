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


}