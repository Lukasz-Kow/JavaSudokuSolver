import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SudokuColumnTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    @Test
    void printColumnTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        sudokuColumn.print();
        assertNotNull(sudokuColumn);
    }

    @Test
    void columnIsValidTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertTrue(sudokuColumn.isValid());
    }


    @Test
    void SudokuColumnIsNotValidTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.set(0,0,1);
        sudokuBoard.set(2,0,1);
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertFalse(sudokuColumn.isValid());
    }

    @Test
    void SudokuColumnsFieldEqual0Test(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.set(0,0,0);
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertFalse(sudokuColumn.isValid());
    }

}