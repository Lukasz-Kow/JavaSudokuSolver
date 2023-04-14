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

    @Override
    public String toString() {
        String message = "";
        for (int i = 0; i < 9; i++) {
            message += row.get(i).getFieldValue() + " ";
        }
        return "SudokuRow: \n" + message;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof SudokuRow)) {
            return false;
        }

        SudokuRow tempRow = (SudokuRow) o;

        // Perform checking
        for (int i = 0; i < 9; i++) {
            if (row.get(i).getFieldValue() != tempRow.row.get(i).getFieldValue()) {
                return false;
            }
        }
        return true;

    }

}
