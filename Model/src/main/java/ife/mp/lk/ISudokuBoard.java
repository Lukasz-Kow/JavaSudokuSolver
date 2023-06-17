package ife.mp.lk;

import java.io.Serializable;

public interface ISudokuBoard extends Serializable, Cloneable {

    void solve();

    int get(int x, int y);

    void set(int x, int y, int value);

    SudokuRow getRow(int y);

    SudokuColumn getColumn(int x);

    SudokuBox getBox(int x);

    SudokuField getField(int x, int y);

    boolean checkBoard();

    void removeFieldsByDifficultyLevel(Level level);

    void removeFields(int numberOfFieldsToRemove);

    boolean equals(Object obj);

    String toString();

    int hashCode();

    ISudokuBoard clone() throws CloneNotSupportedException;
}