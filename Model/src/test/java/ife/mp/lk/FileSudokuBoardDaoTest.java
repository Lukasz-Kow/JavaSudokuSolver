//package ife.mp.lk;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class FileSudokuBoardDaoTest{
//
//    private String fileName;
//
//    FileInputStream fis = null;
//    ObjectInputStream ois = null;
//    FileOutputStream fos = null;
//    ObjectOutputStream oos = null;
//
//    private static final String FILE_NAME = "test_board.bin";
//
//    @Test
//    void testReadThrowsIOException() {
//        // Given
//        FileSudokuBoardDao<SudokuBoard> dao = new FileSudokuBoardDao<>(FILE_NAME);
//
//        // When
//        Exception exception = assertThrows(RuntimeException.class, dao::read);
//
//        // Then
//        assertEquals("IOException is caught: java.io.FileNotFoundException", exception.getMessage());
//    }
//
//}
//
//
//
//
//
//
//
