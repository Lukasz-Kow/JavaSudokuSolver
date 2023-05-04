package ife.mp.lk;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

public class FileSudokuBoardDaoTest {

    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    static BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
    static SudokuBoard sudokuBoard = new SudokuBoard(solver);

    @BeforeAll
    static void setUp() {
        System.out.println("Setting up");
        sudokuBoard.solve();
        sudokuBoard.checkBoard();
    }

    @Test
    void readAndWriteTest() throws Exception {

        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>) factory.getFileDao("test.txt")) {
            dao.write(sudokuBoard);
            System.out.println("Data possibly written");
        }
        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>) factory.getFileDao("test.txt")) {
            SudokuBoard previous = dao.read();
            System.out.println("* Previous data\n" + previous.getBox(0).toString());
        }

    }
    @Test
    void readFailTest() throws Exception {

        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                factory.getFileDao("/this/is/impossible/path/test.txt")) {
            SudokuBoard previous = dao.read();
            System.out.println("* Previous data\n" + previous.getBox(0).toString());
        } catch (RuntimeException e) {
            System.out.println("File not found");
        }
    }

    @Test
    void writeFailTest() throws Exception {

        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                factory.getFileDao("/this/is/impossible/path/test.txt")) {
            dao.write(sudokuBoard);
            System.out.println("Data possibly written");
        } catch (RuntimeException e) {
            System.out.println("File not found");
        }
    }



}