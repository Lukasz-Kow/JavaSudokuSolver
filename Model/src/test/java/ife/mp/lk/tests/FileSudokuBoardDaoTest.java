package ife.mp.lk.tests;

import ife.mp.lk.*;
import ife.mp.lk.exeptions.Exceptions_Dao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest {

    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();

    static BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();

    static SudokuBoardsCache cache = new SudokuBoardsCache();

    static SudokuBoard sudokuBoard = cache.get("Empty Sudoku Board");

    private static final Logger logger = LoggerFactory.getLogger(FileSudokuBoardDaoTest.class);

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("errors");



    @BeforeAll
    static void setUp() {
        logger.atInfo().log("testing setUp");
        sudokuBoard.solve();
        sudokuBoard.checkBoard();
    }

    //TODO: fix this test
        @Test
        void readAndWriteTest() throws Exception {
            logger.atInfo().log("testing readAndWrite");

            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.write(sudokuBoard);
            }

            ISudokuBoard previous;

            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("test.txt")) {
                previous = dao.read();
            }

            assertTrue(sudokuBoard.equals(previous));

        }



    @Test
    void fisReadTestExec() {
        logger.atInfo().log("testing fisReadTestExec");


        Exception e = assertThrows(Exceptions_Dao.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.read();
                dao.read();
            }
        });

        assertEquals(resourceBundle.getString("ErrorReading"), e.getMessage());
    }


    @Test
    void fisWriteTestExec() {
        logger.atInfo().log("testing fisWriteTestExec");


        Exception e = assertThrows(Exceptions_Dao.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("test.txt")) {
                dao.write(sudokuBoard);
                dao.write(sudokuBoard);
            }
        });

        assertEquals(resourceBundle.getString("ErrorWriting"), e.getMessage());
    }


    @Test
    void readFailTest() {
        logger.atInfo().log("testing readFailTest");

        Exception e = assertThrows(Exceptions_Dao.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("/this/is/impossible/nonexistent.txt")) {
                ISudokuBoard testBoard = dao.read();
            }
        });


        assertEquals(resourceBundle.getString("ErrorReading"), e.getMessage());
    }

    @Test
    void writeFailTest() {
        logger.atInfo().log("testing writeFailTest");

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        PrintStream logStream = new PrintStream(logOutput);
        System.setErr(logStream);

        Exception e = assertThrows(Exceptions_Dao.class, () -> {
            try (FileSudokuBoardDao<ISudokuBoard> dao = (FileSudokuBoardDao<ISudokuBoard>)
                    factory.getFileDao("/this/is/impossible/nonexistent.txt")) {
                dao.write(sudokuBoard);
            }
        });

        String logMessage = logOutput.toString();
        System.setErr(System.err);

        assertEquals(resourceBundle.getString("ErrorWriting"), e.getMessage());
    }




}