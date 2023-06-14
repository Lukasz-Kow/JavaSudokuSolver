package ife.mp.lk;


public class SudokuBoardDaoFactory {

    Dao<ISudokuBoard> getFileDao(String fileName) {
        return new FileSudokuBoardDao<ISudokuBoard>(fileName);
    }

}
