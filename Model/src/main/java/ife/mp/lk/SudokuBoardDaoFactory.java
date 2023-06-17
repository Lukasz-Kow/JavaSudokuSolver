package ife.mp.lk;


public class SudokuBoardDaoFactory {

    public Dao<ISudokuBoard> getFileDao(String fileName) {
        return new FileSudokuBoardDao<>(fileName);
    }

}
