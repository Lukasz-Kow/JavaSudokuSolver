package ife.mp.lk;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.*;

public class SudokuBoard implements Serializable, Cloneable {


    private List<SudokuRow> rows = Arrays.asList(new SudokuRow[9]);
    private List<SudokuColumn> columns = Arrays.asList(new SudokuColumn[9]);
    private List<SudokuBox> boxes = Arrays.asList(new SudokuBox[9]);

    private List<SudokuField> fields = Arrays.asList(new SudokuField[81]);

    private SudokuSolver solver;

    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;
        int offset = 0;
        for (int i = 0; i < 9; i++) {
            List<SudokuField> columnFields = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                fields.set(j + offset, new SudokuField(0));
                columnFields.add(fields.get(j + offset));
            }
            offset += 9;
            columns.set(i, new SudokuColumn(columnFields));
        }

        offset = 0;

        for (int i = 0; i < 9; i++) {
            List<SudokuField> temp = new ArrayList<>();
            for (int j = 0; j < 81; j += 9) {
                temp.add(fields.get(j + offset));
            }
            offset += 1;
            rows.set(i, new SudokuRow(temp));
        }

        Integer offsetA = 0;
        Integer offsetB = 0;
        Integer offsetC = 0;


        for (int z = 0; z < 3; z++) {
            for (int k = 0; k < 3; k++) {
                List<SudokuField> tempFieldsList = Arrays.asList(new SudokuField[9]);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        tempFieldsList.set(i + j * 3, fields.get(j + offsetA % 27  + offsetB % 9  + offsetC));
                    }
                    offsetA += 9;
                }
                offsetB += 3;
                SudokuBox box = new SudokuBox(tempFieldsList);
                boxes.set(z * 3 + k, box);
            }
            offsetA += 27;
        }
    }


    public void solve() {
        solver.solve(this);
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(fields.get(i + j * 9).getFieldValue() + " ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("---------------------");
            }
        }
        System.out.println();
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

    public boolean checkBoard() {
        for (int j = 0; j < 9; j++) {
            if (!boxes.get(j).isValid()) {
                return false;
            }
        }
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

        return true;
    }

    public void removeFieldsByDifficultyLevel(Level level) {
        if (level == Level.EASY) {
            removeFields(40);
        } else if (level == Level.MEDIUM) {
            removeFields(50);
        } else if (level == Level.HARD) {
            removeFields(60);
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
        return (SudokuBoard) super.clone();
    }

}