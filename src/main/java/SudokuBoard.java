

public class SudokuBoard {


    private SudokuRow Rows[] = new SudokuRow[9];
    private SudokuColumn Columns[] = new SudokuColumn[9];
    private SudokuBox Boxes[][] = new SudokuBox[3][3];

    private SudokuField fields[][] = new SudokuField[9][9];

    private SudokuSolver solver;

    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                this.fields[i][j] = new SudokuField(0);
            }

        }

        for (int i = 0; i < 9; i++) {
            Rows[i] = new SudokuRow(fields[i]);
        }

        for (int i = 0; i < 9; i++) {
            SudokuField[] temp = new SudokuField[9];
            for (int j = 0; j < 9; j++) {
                temp[j] = fields[j][i];
            }
            Columns[i] = new SudokuColumn(temp);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SudokuField[][] temp = new SudokuField[3][3];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        temp[k][l] = fields[i * 3 + k][j * 3 + l];
                    }
                }
                Boxes[i][j] = new SudokuBox(temp);
            }
        }

    }


    public void solve() {
        solver.solve(this);
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(fields[i][j].getFieldValue() + " ");
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


    public int get(int x, int y){
        return fields[x][y].getFieldValue();
    }

    public void set(int x, int y, int value){
        fields[x][y].setValue(value);
    }
    public SudokuRow getRow(int y){
        return Rows[y];
    }

    public SudokuColumn getColumn(int x){
        return Columns[x];
    }

    public SudokuBox getBox(int x, int y){
        return Boxes[x][y];
    }

    public boolean checkBoard(){
        for (int i = 0; i < 9; i++) {
            if (!Rows[i].isValid()) {
                return false;
            }
            if (!Columns[i].isValid()) {
                return false;
            }
            for (int j = 0; j < 9; j++) {
                if (!Boxes[i][j].isValid()) {
                    return false;
                }
            }
        }
        return true;
    }
}
