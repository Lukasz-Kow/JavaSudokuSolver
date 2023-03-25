public class SudokuColumn {
    private SudokuField[] column;

    public SudokuColumn() {
        column = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            column[i] = new SudokuField(0);
        }
    }
    public boolean isValid(){
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (column[i].getFieldValue() == column[j].getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
