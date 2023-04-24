package IFE_MP_LK;

import org.apache.commons.lang3.builder.*;
public class SudokuField {
    private int value;

    public SudokuField(int value) {
        this.value = value;
    }

    public int getFieldValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
