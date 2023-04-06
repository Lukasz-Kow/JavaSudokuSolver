import java.util.List;

public class SudokuColumn extends SudokuElement {
    private List<SudokuField> column;

    public SudokuColumn(List<SudokuField> column) {
        this.column = column;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (column.get(i).getFieldValue() == column.get(j).getFieldValue()
                        || column.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(column.get(i).getFieldValue() + "\n");
        }
        System.out.println();
    }
}
