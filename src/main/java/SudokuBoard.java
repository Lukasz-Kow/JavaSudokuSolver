import java.util.*;

public class SudokuBoard {


    private List<SudokuRow> rows = Arrays.asList(new SudokuRow[9]);
    private List<SudokuColumn> columns = Arrays.asList(new SudokuColumn[9]);
    private List<List<SudokuBox>> boxes = new ArrayList<>();

    private List<SudokuField> fields = Arrays.asList(new SudokuField[81]);

    private SudokuSolver solver;

    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;
        int offset = 0;
        for (int i = 0; i < 9; i++) {
            List<SudokuField> rowFields = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                fields.set(j + offset, new SudokuField(0));
                rowFields.add(fields.get(j + offset));
            }
            offset += 9;
            rows.set(i, new SudokuRow(rowFields));
        }

        offset = 0;

        for (int i = 0; i < 9; i++) {
            List<SudokuField> temp = new ArrayList<>();
            for (int j = 0; j < 81; j += 9) {
                temp.add(fields.get(j + offset));
            }
            offset += 1;
            columns.set(i, new SudokuColumn(temp));
        }

        for (int z = 0; z < 3; z++) {
            List<SudokuBox> rowOfBoxes = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                List<List<SudokuField>> tempBox = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    List<SudokuField> innerBoxRow = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            innerBoxRow.add(fields.get(i * 3 + k + (j * 3 + l) * 9));
                        }
                    }
                    tempBox.add(innerBoxRow);
                }
                rowOfBoxes.add(new SudokuBox(tempBox));
            }
            boxes.add(rowOfBoxes);
        }

    }


    public void solve() {
        solver.solve(this);
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(fields.get(i + j * 9).getFieldValue() + " ");
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
        return fields.get(x + y * 9).getFieldValue();
    }

    public void set(int x, int y, int value) {
        fields.get(x + y * 9).setValue(value);
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
        //columns
        for (int i = 0; i < 9; i++) {
            if (!rows.get(i).isValid()) {
                return false;
            }
        }
        //rows
        for (int i = 0; i < 9; i++) {
            if (!columns.get(i).isValid()) {
                return false;
            }
        }

        return true;
    }
}