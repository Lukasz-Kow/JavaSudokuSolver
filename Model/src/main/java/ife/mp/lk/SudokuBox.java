package ife.mp.lk;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;



public class SudokuBox extends SudokuElement implements Cloneable  {



    public SudokuBox(List<SudokuField> box) {
        super(box);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SudokuBox)) {
            return false;
        }

        SudokuBox other = (SudokuBox) obj;

        return new EqualsBuilder()
                .append(elements, other.elements)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("box", elements)
                .toString();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        for (int i = 0; i < elements.size(); i++) {
            builder.append(elements.get(i).getFieldValue());
        }
        return builder.toHashCode();
    }

    @Override
    public SudokuBox clone() {
        return new SudokuBox(getElements());

    }
}