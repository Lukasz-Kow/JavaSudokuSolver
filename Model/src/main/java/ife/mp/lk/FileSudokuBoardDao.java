package ife.mp.lk;

import ife.mp.lk.exeptions.Exceptions_Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ResourceBundle;

public class FileSudokuBoardDao<SudokuBoardT> implements Dao<SudokuBoardT>, AutoCloseable {

    private final String fileName;

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("errors");
    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);


    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoardT read() throws IOException, ClassNotFoundException {
        if (fis != null || ois != null) {
            logger.error("Error: ", new Exceptions_Dao(resourceBundle.getString("ReaderUsed")));
            throw new Exceptions_Dao(resourceBundle.getString("ReaderUsed"));
        }
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);

            SudokuBoardT board = (SudokuBoardT) ois.readObject();
            ois.close();
            fis.close();
            return board;
        } catch (IOException e) {
            logger.error("Error: ", e);
            throw new Exceptions_Dao(resourceBundle.getString("ErrorReading"), e);
        }
    }

    @Override
    public void write(SudokuBoardT obj) throws IOException {
        if (fos != null || oos != null) {
            logger.error("Error: ", new Exceptions_Dao(resourceBundle.getString("WriterUsed")));
            throw new Exceptions_Dao(resourceBundle.getString("WriterUsed"));
        }
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (IOException e) {
            logger.error("Error: ", e);
            throw new Exceptions_Dao(resourceBundle.getString("ErrorWriting"), e);
        }
    }


    @Override
    public void close() {
        if (fis != null || ois != null) {
            try {
                fis.close();
                ois.close();
            } catch (IOException ex) {
                logger.error("Error: ", ex);
                throw new Exceptions_Dao(resourceBundle.getString("ErrorClosingFileInput"), ex);
            }
        }

        if (fos != null || oos != null) {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                logger.error("Error: ", ex);
                throw new Exceptions_Dao(resourceBundle.getString("ErrorClosingFileOutput"), ex);
            }
        }
    }
}
