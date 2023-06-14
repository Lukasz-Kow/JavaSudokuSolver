package ife.mp.lk;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

            // 1. Initial SudokuBoard
            BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
            SudokuBoard sudokuBoard = new SudokuBoard(solver);

            sudokuBoard.solve();
//            sudokuBoard.printBoard();
//            sudokuBoard.checkBoard();

            // 2. Creating a clone
            SudokuBoard sudokuBoardClone = sudokuBoard.clone();

            // 3. Modifying the clone
            sudokuBoardClone.set(0, 0, 8);
            sudokuBoardClone.set(1, 0, 8);

            // 4. Printing the clone
            SudokuRow box = sudokuBoardClone.getRow(0);
            sudokuBoardClone.printBoard();
            System.out.println(box);




            // Modify the original
//            sudokuBoard.set(0, 0, 8);
//            sudokuBoard.set(1, 0, 8);

            // Print the original
//            sudokuBoard.printBoard();
//            SudokuBox box = sudokuBoard.getBox(0);
//            System.out.println(box);

//            sudokuBoard.printBoard();

            // Printing the clone
//            System.out.println(box);

//            SudokuBoardsCache cache = new SudokuBoardsCache();
//            SudokuBoard sudokuBoard2 = cache.get("Solved Sudoku Board");
//            sudokuBoard2.set(0, 0, 8);
//            sudokuBoard2.set(1, 0, 8);
//
//
//            SudokuRow box = sudokuBoard2.getRow(0);
//            System.out.println(box);
////
//            sudokuBoard2.printBoard();
////            System.out.println(sudokuBoard2.checkBoard());
//
//            SudokuBoard sudokuBoard3 = cache.get("Empty Sudoku Board");
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
