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

    @Override
    public String toString() {
        return "SudokuField: " + value;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof SudokuField)) {
            return false;
        }

        SudokuField tempField = (SudokuField) o;

        // Perform checking

        return value == tempField.getFieldValue();
    }
}
