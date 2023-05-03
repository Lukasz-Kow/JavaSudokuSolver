package ife.mp.lk;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileSudokuBoardDaoTest {

    @Test
    void writeTest() throws Exception {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);




        sudokuBoard.solve();
        sudokuBoard.printBoard();
        sudokuBoard.checkBoard();

        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>) factory.getFileDao("test.txt")) {
            dao.write(sudokuBoard);
            System.out.println("Data possibly written");
        }
        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>) factory.getFileDao("test.txt")) {
            SudokuBoard previous = dao.read();
            System.out.println("* Previous data\n" + previous.getBox(0).toString());
        }
    }

}