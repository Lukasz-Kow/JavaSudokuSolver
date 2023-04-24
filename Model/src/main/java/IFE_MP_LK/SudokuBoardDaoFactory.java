package IFE_MP_LK;


public class SudokuBoardDaoFactory {


    Dao getFileDao(String fileName) {
        return new FileSudokuBoardDao(fileName);
    }

}
