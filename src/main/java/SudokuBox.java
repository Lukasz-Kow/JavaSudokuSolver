import java.util.List;

public class SudokuBox extends SudokuElement {
    private List<SudokuField> box;

    public SudokuBox(List<SudokuField> box) {
        this.box = box;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (box.get(i).getFieldValue() == box.get(j).getFieldValue()
                        || box.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(box.get(i).getFieldValue() + " ");
        }
    }


}