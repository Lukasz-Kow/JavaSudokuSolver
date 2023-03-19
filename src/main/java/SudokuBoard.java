

public class SudokuBoard {

    private Integer[][] board;
    private SudokuSolver solver;

    public SudokuBoard(SudokuSolver solver) {
        board = new Integer[9][9];
        this.solver = solver;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
    }
    
    public Integer getValue(int row, int column) {
        return board[row][column];
    }

    public void setValue(int row, int column, int value) {
        board[row][column] = value;
    }

    public void solve() {
        solver.solve(this);
    }


    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
                }
                    System.out.println();
                if (i == 2 || i == 5) {
                    System.out.println("---------------------");
                }
            }
        System.out.println();
    }
}