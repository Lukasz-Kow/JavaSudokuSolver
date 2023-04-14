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

    @Override
    public String toString() {
        String message = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                message += box.get(i * 3 + j).getFieldValue() + " ";
            }
            message += "\n";
        }
        return "SudokuBox: \n" + message;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof SudokuBox)) {
            return false;
        }

        SudokuBox tempBox = (SudokuBox) o;

        // Perform checking
        for (int i = 0; i < 9; i++) {
            if (box.get(i).getFieldValue() != tempBox.box.get(i).getFieldValue()) {
                return false;
            }
        }
        return true;
    }
}