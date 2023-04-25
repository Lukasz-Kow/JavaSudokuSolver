package IFE_MP_LK;

import java.io.*;

public class FileSudokuBoardDao<SudokuBoard> implements Dao<SudokuBoard> {

    private String fileName;
    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        SudokuBoard board = (SudokuBoard) ois.readObject();
        ois.close();
        fis.close();
        return board;
    }

    @Override
    public void write(SudokuBoard obj) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
        fos.close();
    }

    public void finalise() {
        System.out.println("Finalize");
    }
}
