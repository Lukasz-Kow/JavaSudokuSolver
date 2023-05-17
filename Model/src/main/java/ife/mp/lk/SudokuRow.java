package ife.mp.lk;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;


public class SudokuRow extends SudokuElement implements Cloneable {

    public SudokuRow(List<SudokuField> row) {
        super(row);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("row", elements)
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
                .append(elements, other.elements)
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(elements)
                .toHashCode();
    }

    @Override
    public SudokuRow clone() {
        try {
            SudokuRow cloned = (SudokuRow) super.clone();
            cloned.elements = new ArrayList<>(elements.size());
            for (SudokuField field : elements) {
                cloned.elements.add(field.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
