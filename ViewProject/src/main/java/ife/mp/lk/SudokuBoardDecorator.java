package ife.mp.lk;

public abstract class SudokuBoardDecorator implements ISudokuBoard {

    protected SudokuBoard sudokuBoard;

    public SudokuBoardDecorator(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    @Override
    public void solve() {
        this.sudokuBoard.solve();
    }

    @Override
    public void printBoard() {
        this.sudokuBoard.printBoard();
    }

    @Override
    public int get(int x, int y) {
        return this.sudokuBoard.get(x, y);
    }

    @Override
    public void set(int x, int y, int value) {
        this.sudokuBoard.set(x, y, value);
    }

    @Override
    public SudokuRow getRow(int y) {
        return this.sudokuBoard.getRow(y);
    }

    @Override
    public SudokuColumn getColumn(int x) {
        return this.sudokuBoard.getColumn(x);
    }

    @Override
    public SudokuBox getBox(int x) {
        return this.sudokuBoard.getBox(x);
    }

    @Override
    public SudokuField getField(int x, int y) {
        return this.sudokuBoard.getField(x, y);
    }

    @Override
    public boolean checkBoard() {
        return this.sudokuBoard.checkBoard();
    }

    @Override
    public void removeFieldsByDifficultyLevel(Level level) {
        this.sudokuBoard.removeFieldsByDifficultyLevel(level);
    }

    @Override
    public void removeFields(int numberOfFieldsToRemove) {
        this.sudokuBoard.removeFields(numberOfFieldsToRemove);
    }

    @Override
    public ISudokuBoard clone() throws CloneNotSupportedException {
        return this.sudokuBoard.clone();
    }
}
