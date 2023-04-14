import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


public class SudokuColumn extends SudokuElement {
    private List<SudokuField> column;

    public SudokuColumn(List<SudokuField> column) {
        this.column = column;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (column.get(i).getFieldValue() == column.get(j).getFieldValue()
                        || column.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(column.get(i).getFieldValue() + "\n");
        }
        System.out.println();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(column.get(i).getFieldValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SudokuColumn)) {
            return false;
        }
        SudokuColumn other = (SudokuColumn) obj;
        return new EqualsBuilder()
                .append(column, other.column)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(column)
                .toHashCode();
    }

}
