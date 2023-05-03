package IFE_MP_LK;


public class SudokuBoardDaoFactory {

    Dao<SudokuBoard> getFileDao(String fileName) {
        return new FileSudokuBoardDao<SudokuBoard>(fileName);
    }

}
