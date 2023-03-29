import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SudokuBoxTest {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    @Test
    void printBoxTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuBox sudokuBox = sudokuBoard.getBox(0,0);
        sudokuBox.printBox();
        assertNotNull(sudokuBox);
    }


    @Test
    void BoxIsValidTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        SudokuBox sudokuBox = sudokuBoard.getBox(0,0);
        assertTrue(sudokuBox.isValid());
    }


    @Test
    void SudokuBoxIsNotValidTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.set(0,0,1);
        sudokuBoard.set(0,1,1);
        SudokuBox sudokuBox = sudokuBoard.getBox(0,0);
        assertFalse(sudokuBox.isValid());
    }


    @Test
    void SudokuBoxsFieldEqual0Test(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();
        sudokuBoard.set(0,0,0);
        SudokuBox sudokuBox = sudokuBoard.getBox(0,0);
        assertFalse(sudokuBox.isValid());
    }


    @Test
    void CheckBoardBoxFalseTest(){
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.solve();

        sudokuBoard.set(3,4,1);

        assertFalse(sudokuBoard.checkBoard());
    }
}