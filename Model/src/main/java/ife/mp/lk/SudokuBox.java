package ife.mp.lk;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;



public class SudokuBox extends SudokuElement  {
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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SudokuBox)) {
            return false;
        }

        SudokuBox other = (SudokuBox) obj;

        return new EqualsBuilder()
                .append(box, other.box)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("box", box)
                .toString();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        for (int i = 0; i < box.size(); i++) {
            builder.append(box.get(i).getFieldValue());
        }
        return builder.toHashCode();
    }

}