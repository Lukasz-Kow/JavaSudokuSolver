public class SudokuColumn {
    private SudokuField[] column;

    public SudokuColumn(SudokuField[] column) {
        this.column = column;
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

    public void printColumn() {
        for (int i = 0; i < 9; i++) {
            System.out.print(column[i].getFieldValue() + "\n");
        }
        System.out.println();
    }
}
