package IFE_MP_LK;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSudokuBoardDao<SudokuBoard> implements Dao<SudokuBoard>, AutoCloseable {

    private String fileName;

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() throws IOException, ClassNotFoundException {
        if (fis != null || ois != null) {
            throw new RuntimeException("reader already used");
        }
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);

            SudokuBoard board = (SudokuBoard) ois.readObject();
            ois.close();
            fis.close();
            return board;
        } catch (IOException e) {
            System.out.println("IOException is caught: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(SudokuBoard obj) throws IOException {
        if (fos != null || oos != null) {
            throw new RuntimeException("writer already used");
        }
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("IOException is caught (write) " + e);
        }
    }

    public void finalise() {
        System.out.println("Finalize");
    }

    @Override
    public void close() throws Exception {
        if (fis != null || ois != null) {
            try {
                fis.close();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (fos != null || oos != null) {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
