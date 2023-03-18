
public class Main {
    public static void main(String[] args) {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);

        sudokuBoard.setValue(0, 0, 5);
        sudokuBoard.setValue(0, 1, 9);

        sudokuBoard.solve();
        sudokuBoard.printBoard();
    }
}