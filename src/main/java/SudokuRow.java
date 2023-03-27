public class SudokuRow {
    private SudokuField[] row;

    public SudokuRow(SudokuField[] row) {
        this.row = row;
    }

    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (row[i].getFieldValue() == row[j].getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }


    public void printRow() {
        for (int i = 0; i < 9; i++) {
            System.out.print(row[i].getFieldValue() + " ");
        }
        System.out.println();
    }

}
