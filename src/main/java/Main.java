
public class Main {
    public static void main(String[] args) {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);

        sudokuBoard.solve();
        sudokuBoard.printBoard();
        sudokuBoard.checkBoard();

        System.out.println(sudokuBoard.getBox(0));
    }
}
