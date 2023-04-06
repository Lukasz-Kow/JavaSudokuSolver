import java.util.List;

public class SudokuRow extends SudokuElement {
    private List<SudokuField> row;

    public SudokuRow(List<SudokuField> row) {
        this.row = row;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (row.get(i).getFieldValue() == row.get(j).getFieldValue()
                        || row.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(row.get(i).getFieldValue() + " ");
        }
        System.out.println();
    }

}
