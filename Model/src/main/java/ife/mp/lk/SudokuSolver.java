package ife.mp.lk;

import ife.mp.lk.exeptions.NoSolutionException;

interface SudokuSolver {
    void solve(SudokuBoard board) throws NoSolutionException;

}
