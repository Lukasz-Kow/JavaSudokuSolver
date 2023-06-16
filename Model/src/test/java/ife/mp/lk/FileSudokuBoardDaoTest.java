package ife.mp.lk;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest {

    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    static BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    static SudokuBoardsCache cache = new SudokuBoardsCache();
    static SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");
    private static final Logger logger = LoggerFactory.getLogger(FileSudokuBoardDaoTest.class);


    @BeforeAll
    static void setUp() {
        logger.atInfo().log("testing setUp");
        sudokuBoard.solve();
        sudokuBoard.checkBoard();
    }

    //TODO: fix this test
//    @Test
//    void readAndWriteTest() throws Exception {
//
//        try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
//                factory.getFileDao("test.txt")) {
//            dao.write(sudokuBoard);
//        }
//
//        ISudokuBoard previous;
//
//        try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
//                factory.getFileDao("test.txt")) {
//            previous = dao.read();
//        }
//
//        assertTrue(sudokuBoard.equals(previous));
//
//    }



    @Test
    void fisReadTestExec() {
        logger.atInfo().log("testing fisReadTestExec");

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        PrintStream logStream = new PrintStream(logOutput);
        System.setErr(logStream);

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.read();
                dao.read();
            }
        });

        String logMessage = logOutput.toString();
        System.setErr(System.err);

        assertEquals("Error reading file", e.getMessage());
    }


    @Test
    void fisWriteTestExec() {
        logger.atInfo().log("testing fisWriteTestExec");

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        PrintStream logStream = new PrintStream(logOutput);
        System.setErr(logStream);

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.write(sudokuBoard);
                dao.write(sudokuBoard);
            }
        });

        String logMessage = logOutput.toString();
        System.setErr(System.err);

        assertEquals("Error writing file", e.getMessage());
    }


    @Test
    void readFailTest() {
        logger.atInfo().log("testing readFailTest");

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        PrintStream logStream = new PrintStream(logOutput);
        System.setErr(logStream);

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("/this/is/impossible/nonexistent.txt")) {
                ISudokuBoard testBoard = dao.read();
            }
        });

        String logMessage = logOutput.toString();
        System.setErr(System.err);

        assertEquals("Error reading file", e.getMessage());
    }

    @Test
    void writeFailTest() {
        logger.atInfo().log("testing writeFailTest");

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        PrintStream logStream = new PrintStream(logOutput);
        System.setErr(logStream);

        Exception e = assertThrows(RuntimeException.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("/this/is/impossible/nonexistent.txt")) {
                dao.write(sudokuBoard);
            }
        });

        String logMessage = logOutput.toString();
        System.setErr(System.err);

        assertEquals("Error writing file", e.getMessage());
    }



    @Test
    void finaliseTest() {
        logger.atInfo().log("testing finaliseTest");
        try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                factory.getFileDao("test.txt")) {
            dao.read();
            dao.write(sudokuBoard);

        } catch (IOException e) {
            logger.error("Error: ", e);
        } catch (Throwable e) {
            logger.error("Error: ", e);
        }
    }



}