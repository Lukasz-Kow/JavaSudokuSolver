public class SudokuRow {
    private SudokuField[] row;

    public SudokuRow(Integer[] integers) {
        row = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new SudokuField(0);
        }
    }
    private boolean isValid(){
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (row[i].getValue() == row[j].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

}
