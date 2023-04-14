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

    @Override
    public String toString() {
        String message = "";
        for (int i = 0; i < 9; i++) {
            message += column.get(i).getFieldValue() + " ";
        }
        return "SudokuColumn: \n" + message;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof SudokuColumn)) {
            return false;
        }

        SudokuColumn tempColumn = (SudokuColumn) o;

        // Perform checking
        for (int i = 0; i < 9; i++) {
            if (column.get(i).getFieldValue() != tempColumn.column.get(i).getFieldValue()) {
                return false;
            }
        }
        return true;

    }
}
