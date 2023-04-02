import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {


    private List<SudokuRow> rows = new ArrayList<>();
    private List<SudokuColumn> columns = new ArrayList<>();
    private List<List<SudokuBox>> boxes = new ArrayList<>();

    private List<List<SudokuField>> fields = new ArrayList<>();

    private SudokuSolver solver;

    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;
        for (int i = 0; i < 9; i++) {
            List<SudokuField> rowFields = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                rowFields.add(new SudokuField(0));
            }
            this.fields.add(rowFields);
        }

        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow(fields.get(i)));
        }

        for (int i = 0; i < 9; i++) {
            List<SudokuField> temp = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                temp.add(fields.get(j).get(i));
            }
            columns.add(new SudokuColumn(temp));
        }

        for (int i = 0; i < 3; i++) {
            List<List<SudokuBox>> boxRow = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                List<SudokuField> boxFields = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        boxFields.add(fields.get(i * 3 + k).get(j * 3 + l));
                    }
                }
               //boxRow.add(new SudokuBox(boxFields));
            }
            //boxes.add(boxRow);
        }

    }


    public void solve() {
        solver.solve(this);
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(fields.get(i).get(j).getFieldValue() + " ");
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


    public int get(int x, int y) {
        return fields.get(x).get(y).getFieldValue();
    }

    public void set(int x, int y, int value) {
        fields.get(x).get(y).setValue(value);
    }

    public SudokuRow getRow(int y) {
        return rows.get(y);
    }

    public SudokuColumn getColumn(int x) {
        return columns.get(x);
    }

    public SudokuBox getBox(int x, int y) {
        return boxes.get(x).get(y);
    }

    public boolean checkBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!boxes.get(i).get(j).isValid()) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!rows.get(i).isValid()) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!columns.get(i).isValid()) {
                return false;
            }
        }

        return true;
    }
}