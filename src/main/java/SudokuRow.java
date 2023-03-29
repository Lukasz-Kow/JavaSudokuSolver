public class SudokuRow extends SudokuElement{
    private SudokuField[] row;

    public SudokuRow(SudokuField[] row) {
        this.row = row;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (row[i].getFieldValue() == row[j].getFieldValue() || row[i].getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(row[i].getFieldValue() + " ");
        }
        System.out.println();
    }

}
