package ife.mp.lk;


import java.io.Serializable;

abstract class SudokuElement implements Serializable {

    abstract boolean isValid();

    abstract void print();
}
