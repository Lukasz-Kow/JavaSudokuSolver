
public class Main {
    public static void main(String[] args) {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);


        sudokuBoard.set(0, 0, 1);
        sudokuBoard.set(1, 0, 2);

        sudokuBoard.set(2, 3, 3);
        sudokuBoard.set(3, 4, 4);
        sudokuBoard.printBoard();

    }
}
