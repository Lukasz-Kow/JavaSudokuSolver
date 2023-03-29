public class SudokuColumn extends SudokuElement{
    private SudokuField[] column;

    public SudokuColumn(SudokuField[] column) {
        this.column = column;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (column[i].getFieldValue() == column[j].getFieldValue() || column[i].getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(column[i].getFieldValue() + "\n");
        }
        System.out.println();
    }
}
