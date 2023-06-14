package ife.mp.lk;

import java.io.Serializable;

public interface ISudokuField extends Comparable<ISudokuField>, Cloneable, Serializable {
    int getFieldValue();

    void setValue(int value);

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();

    @Override
    String toString();


}
