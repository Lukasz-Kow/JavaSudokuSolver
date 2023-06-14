package ife.mp.lk;


import java.io.Serializable;
import java.util.List;

class SudokuElement implements Serializable {

    public List<SudokuField> elements;

    SudokuElement(List<SudokuField> elements) {
        if (elements.size() != 9) {
            throw new IllegalArgumentException("Entity must contain 9 fields");
        }
        this.elements = elements;
    }

    public List<SudokuField> getElements() {
        return elements;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (elements.get(i).getFieldValue() == elements.get(j).getFieldValue()
                        || elements.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(elements.get(i).getFieldValue() + " ");
        }
    }
}
