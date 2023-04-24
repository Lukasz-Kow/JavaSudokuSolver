
public class FileSudokuBoardDao<SudokuBoard> implements Dao<SudokuBoard> {

    private String fileName;
    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() {
        return null;
    }

    @Override
    public void write(SudokuBoard obj) {

    }

    public void finalise() {
        System.out.println("Finalize");
    }
}
