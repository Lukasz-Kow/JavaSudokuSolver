package ife.mp.lk;


public class Main {
    public static void main(String[] args) {
            BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
            SudokuBoard sudokuBoard = new SudokuBoard(solver);




            /*
                        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
                        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                                  factory.getFileDao("test.txt")) {
                            dao.write(sudokuBoard);
                            System.out.println("Data possibly written");
                        }
                        try (FileSudokuBoardDao<SudokuBoard> dao = (FileSudokuBoardDao<SudokuBoard>)
                                  factory.getFileDao("test.txt")) {
                            SudokuBoard previous = dao.read();
                            System.out.println("* Previous data\n" + previous.getBox(0).toString());
                        }
            */


    }
}
