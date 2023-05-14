package ife.mp.lk;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;


public class SudokuColumn extends SudokuElement implements Cloneable {


    public SudokuColumn(List<SudokuField> column) {
        super(column);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("column", elements)
                .toString();
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
    public SudokuColumn clone() {
        try {
            SudokuColumn cloned = (SudokuColumn) super.clone();
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
