
public class Main {
    public static void main(String[] args) {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);


        sudokuBoard.set(0, 0, 1);
        sudokuBoard.set(1, 0, 2);

        sudokuBoard.set(2, 3, 3);
        sudokuBoard.set(3, 4, 4);
        sudokuBoard.printBoard();
//        SudokuRow testRow = sudokuBoard.getRow(0);
//        testRow.printRow();
//        SudokuColumn testColumn = sudokuBoard.getColumn(0);
//        testColumn.printColumn();

//        SudokuBox testBox = sudokuBoard.getBox(0, 0);
//        SudokuBox testBox2 = sudokuBoard.getBox(0, 1);
//        SudokuBox testBox3 = sudokuBoard.getBox(1, 1);
//        testBox.printBox();
//        testBox2.printBox();
//        testBox3.printBox();


//        sudokuBoard.solve();
//        sudokuBoard.printBoard();
    }
}
