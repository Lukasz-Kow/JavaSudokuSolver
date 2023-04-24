package IFE_MP_LK;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


public class SudokuRow extends SudokuElement {
    private List<SudokuField> row;

    public SudokuRow(List<SudokuField> row) {
        this.row = row;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (row.get(i).getFieldValue() == row.get(j).getFieldValue()
                        || row.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    void print() {
        for (int i = 0; i < 9; i++) {
            System.out.print(row.get(i).getFieldValue() + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("row", row)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SudokuRow)) {
            return false;
        }
        SudokuRow other = (SudokuRow) obj;
        return new EqualsBuilder()
                .append(row, other.row)
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(row)
                .toHashCode();
    }

}
