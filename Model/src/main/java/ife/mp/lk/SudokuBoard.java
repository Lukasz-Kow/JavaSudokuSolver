package ife.mp.lk;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.*;

public class SudokuBoard implements ISudokuBoard {


    private final List<SudokuRow> rows;
    private final List<SudokuColumn> columns;
    private final List<SudokuBox> boxes;

    private final List<SudokuField> fields;

    private final SudokuSolver solver;

    public SudokuBoard(SudokuSolver solver) {

        this.fields = Arrays.asList(new SudokuField[81]);
        this.rows = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.boxes = new ArrayList<>();


        this.solver = solver;

        for (int i = 0; i < 81; i++) {
            fields.set(i, new SudokuField(0));
        }

        for (int i = 0; i < 9; i++) {
            List<SudokuField> rowFields = Arrays.asList(new SudokuField[9]);
            for (int j = 0; j < 9; j++) {
                rowFields.set(j, fields.get(i * 9 + j));
            }
            rows.add(new SudokuRow(rowFields));
        }

        for (int i = 0; i < 9; i++) {
            List<SudokuField> columnFields = Arrays.asList(new SudokuField[9]);
            for (int j = 0; j < 9; j++) {
                columnFields.set(j, fields.get(j * 9 + i));
            }
            columns.add(new SudokuColumn(columnFields));
        }

        for (int i = 0; i < 9; i++) {
            List<SudokuField> boxFields = Arrays.asList(new SudokuField[9]);
            for (int j = 0; j < 9; j++) {
                boxFields.set(j, fields.get((i / 3) * 27 + (i % 3) * 3 + (j / 3) * 9 + (j % 3)));
            }
            boxes.add(new SudokuBox(boxFields));
        }
    }


    public void solve() {
        solver.solve(this);
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            if (i == 2 || i == 5) {
            }
        }
    }


    public int get(int x, int y) {
        return fields.get(x + y * 9).getFieldValue();
    }

    public void set(int x, int y, int value) {
        fields.get(x + y * 9).setValue(value);
    }

    public SudokuRow getRow(int y) {
        return rows.get(y);
    }

    public SudokuColumn getColumn(int x) {
        return columns.get(x);
    }

    public SudokuBox getBox(int x) {
        return boxes.get(x);
    }

    public SudokuField getField(int x, int y) {
        return fields.get(x + y * 9);
    }

    public boolean checkBoard() {

        //columns
        for (int i = 0; i < 9; i++) {
            if (!rows.get(i).isValid()) {
                return false;
            }
        }
        //rows
        for (int i = 0; i < 9; i++) {
            if (!columns.get(i).isValid()) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (!boxes.get(j).isValid()) {
                return false;
            }
        }

        return true;
    }

    public void removeFieldsByDifficultyLevel(Level level) {
        if (level == Level.EASY) {
            removeFields(20);
        } else if (level == Level.MEDIUM) {
            removeFields(30);
        } else if (level == Level.HARD) {
            removeFields(40);
        }
    }

    public void removeFields(int numberOfFieldsToRemove) {
        Random random = new Random();
        int counter = 0;
        while (counter < numberOfFieldsToRemove) {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if (get(x, y) != 0) {
                set(x, y, 0);
                counter++;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SudokuBoard)) {
            return false;
        }
        SudokuBoard other = (SudokuBoard) obj;
        return new EqualsBuilder()
                .append(this.rows, other.rows)
                .append(this.columns, other.columns)
                .append(this.boxes, other.boxes)
                .append(this.fields, other.fields)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("rows", rows)
                .append("columns", columns)
                .append("boxes", boxes)
                .append("fields", fields)
                .toString();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(rows);
        builder.append(columns);
        builder.append(boxes);
        builder.append(fields);
        return builder.toHashCode();
    }

    @Override
    public SudokuBoard clone() throws CloneNotSupportedException {

        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard clonedBoard = new SudokuBoard(solver);

        // DOBRZE
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                clonedBoard.set(i, j, get(i, j));
            }
        }

        return clonedBoard;

    }

}