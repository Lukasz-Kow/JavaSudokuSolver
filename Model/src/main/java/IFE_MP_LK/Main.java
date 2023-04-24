package IFE_MP_LK;


public class Main {
    public static void main(String[] args) {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);

        SudokuBoard sudokuBoard2 = new SudokuBoard(solver);


        sudokuBoard.solve();
        sudokuBoard.printBoard();
        sudokuBoard.checkBoard();

        //        sudokuBoard2 = sudokuBoard;
        //
        //        System.out.println(sudokuBoard.getRow(0) == sudokuBoard.getRow(1));
        //        System.out.println(sudokuBoard.getRow(0) == sudokuBoard.getRow(0));
        //
        //        System.out.println(sudokuBoard.getColumn(0) == sudokuBoard.getColumn(1));
        //        System.out.println(sudokuBoard.getColumn(0) == sudokuBoard.getColumn(0));
        //
        //        System.out.println(sudokuBoard.getBox(0) == sudokuBoard.getBox(1));
        //        System.out.println(sudokuBoard.getBox(0) == sudokuBoard.getBox(0));
        //
        //        System.out.println(sudokuBoard.get(0,0) == sudokuBoard.get(0,0));
        //        System.out.println(sudokuBoard.get(0,0) == sudokuBoard.get(1,0));

        //        System.out.println(sudokuBoard == sudokuBoard2);



    }
}
