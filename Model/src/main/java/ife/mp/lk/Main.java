package ife.mp.lk;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

            // 1. Initial SudokuBoard
            BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
            SudokuBoard sudokuBoard = new SudokuBoard(solver);

            sudokuBoard.solve();

            // 2. Creating a clone
            SudokuBoard sudokuBoardClone = sudokuBoard.clone();

            // 3. Modifying the clone
            sudokuBoardClone.set(0, 0, 8);
            sudokuBoardClone.set(1, 0, 8);

            // 4. Printing the clone
            SudokuRow box = sudokuBoardClone.getRow(0);
            sudokuBoardClone.printBoard();


    }
}
