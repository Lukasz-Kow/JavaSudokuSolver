package ife.mp.lk;

import java.util.HashMap;
import java.util.Map;

public class SudokuBoardsCache {

    private Map<String, SudokuBoard> cache = new HashMap<>();

    public SudokuBoardsCache() {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);

        BacktrackingSudokuSolver solver2 = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard2 = new SudokuBoard(solver2);
        sudokuBoard2.solve();
        sudokuBoard2.checkBoard();

        cache.put("Empty Sudoku Board", sudokuBoard);
        cache.put("Solved Sudoku Board", sudokuBoard2);

    }

    public SudokuBoard put(String key, SudokuBoard sudokuBoard) {
        cache.put(key, sudokuBoard);
        return sudokuBoard;
    }

    public SudokuBoard get(String key) {
        try {
            return cache.get(key).clone();
        } catch (Exception e) {
            return null;
        }
    }

}
