package ife.mp.lk;


public class SudokuBoardDaoFactory {

    Dao<SudokuBoard> getFileDao(String fileName) {
        return new FileSudokuBoardDao<SudokuBoard>(fileName);
    }

}
