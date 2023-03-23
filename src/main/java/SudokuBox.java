public class SudokuBox {
    private SudokuField[] box;

    public SudokuBox() {
        box = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            box[i] = new SudokuField(0);
        }
    }

    private boolean isValid() {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (box[i].getValue() == box[j].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}