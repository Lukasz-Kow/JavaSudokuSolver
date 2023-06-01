package ife.mp.lk;


public class Main {
    public static void main(String[] args) {
            BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
            SudokuBoard sudokuBoard = new SudokuBoard(solver);

            sudokuBoard.solve();
//            sudokuBoard.printBoard();
            sudokuBoard.checkBoard();

            SudokuBoardsCache cache = new SudokuBoardsCache();
            SudokuBoard sudokuBoard2 = cache.get("Solved Sudoku Board");
            sudokuBoard2.set(0, 0, 8);
            sudokuBoard2.set(0, 1, 8);

            SudokuBox box = sudokuBoard2.getBox(0);
            System.out.println(box);

            sudokuBoard2.printBoard();
            System.out.println(sudokuBoard2.checkBoard());

            SudokuBoard sudokuBoard3 = cache.get("Empty Sudoku Board");
//            sudokuBoard3.printBoard();

//            SudokuBoard sudokuBoard2 = (SudokuBoard) sudokuBoard.clone();
//            System.out.println(sudokuBoard.equals(sudokuBoard2));

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
