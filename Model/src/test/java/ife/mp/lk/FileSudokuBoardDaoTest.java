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

        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                factory.getFileDao("test.txt")) {
            dao.write(sudokuBoard);
        }

        SudokuBoard previous;

        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                factory.getFileDao("test.txt")) {
            previous = dao.read();
        }

        assertTrue(sudokuBoard.equals(previous));

    }

    @Test
    void fisReadTestExec() {

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.read();
                dao.read();
            }
        });

        assertEquals("reader already used", e.getMessage());

    }

    @Test
    void fisWriteTestExec() {

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.write(sudokuBoard);
                dao.write(sudokuBoard);
            }
        });

        assertEquals("writer already used", e.getMessage());
    }

    @Test
    void readFailTest() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                    factory.getFileDao("/this/is/impossible/nonexistent.txt")) {
                SudokuBoard testBoard = dao.read();
            }
        });

        assertEquals("Error reading file", e.getMessage());

    }

    @Test
    void writeFailTest() {

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                    factory.getFileDao("/this/is/impossible/nonexistent.txt")) {
                dao.write(sudokuBoard);
            }
        });

        assertEquals("Error writing file", e.getMessage());
    }

//    @Test
//    void closeIOException() {
//
//        /*
//           TODO: Fix to actually throw IOException
//        */
//
//        Exception e = assertThrows(RuntimeException.class, () -> {
//            try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
//                    factory.getFileDao("nonexistant.txt")) {
//                dao.close();
//            }
//        });
//
////        assertEquals("Error closing file", e.getMessage());
//    }

    @Test
    void finaliseTest() {
        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                factory.getFileDao("test.txt")) {
            dao.read();
            dao.finalise();
            dao.write(sudokuBoard);

        } catch (IOException e) {
            System.out.println("IOException caught");
        } catch (Throwable e) {
            System.out.println("Throwable caught");
        }
    }



}