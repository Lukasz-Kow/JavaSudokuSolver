package ife.mp.lk;

import java.util.*;

public class SudokuBoardWithProgress extends SudokuBoardDecorator {

    public List<Boolean> fieldsAccess = new ArrayList<Boolean>();

    public SudokuBoardWithProgress(SudokuBoard sudokuBoard) {
        super(sudokuBoard);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (get(i, j) == 0) {
                    fieldsAccess.add(false);
                } else {
                    fieldsAccess.add(true);
                }
            }
        }
    }

    public Boolean getAccess(int row, int col) {
        return fieldsAccess.get(row * 9 + col);
    }



}
