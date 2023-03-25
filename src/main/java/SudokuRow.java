public class SudokuRow {
    private SudokuField[] row;

    public SudokuRow() {
        row = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new SudokuField(0);
        }
    }
    public boolean isValid(){
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (row[i].getFieldValue() == row[j].getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }

}
