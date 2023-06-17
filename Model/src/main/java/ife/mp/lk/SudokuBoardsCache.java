package ife.mp.lk;

import ife.mp.lk.exeptions.WrongKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class SudokuBoardsCache {

    private Map<String, SudokuBoard> cache = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(SudokuBoardsCache.class);

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("errors");

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
            if (cache.containsKey(key)) {
                return cache.get(key).clone();
            } else {
                logger.error("Error: ", new WrongKeyException(resourceBundle.getString("WrongKey")));
                throw new WrongKeyException(resourceBundle.getString("WrongKey"));
            }
        } catch (WrongKeyException e) {
            return null;
        }
    }

}
