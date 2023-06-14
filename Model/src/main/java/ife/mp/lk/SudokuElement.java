package ife.mp.lk;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.reflect.Array.get;

public abstract class SudokuElement implements Serializable, Cloneable {

    public List<SudokuField> elements;

    SudokuElement(List<SudokuField> elements) {
        if (elements.size() != 9) {
            throw new IllegalArgumentException("Entity must contain 9 fields");
        }
        this.elements = new ArrayList<>(elements);
    }

    public List<SudokuField> getElements() {
        List<SudokuField> sudokuFields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            sudokuFields.set(i, new SudokuField(elements.get(i).getFieldValue()));
        }
        return sudokuFields;
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

    @Override
    public abstract SudokuElement clone();
}
