public class SudokuColumn {
    private SudokuField[] column;

    public SudokuColumn() {
        column = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            column[i] = new SudokuField(0);
        }
    }
    private boolean isValid(){
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (column[i].getValue() == column[j].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
