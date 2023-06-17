package ife.mp.lk;


import ife.mp.lk.exeptions.IllegalArgumentExce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;




public abstract class SudokuElement implements Serializable, Cloneable {

    public List<SudokuField> elements;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("errors");
    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);


    SudokuElement(List<SudokuField> elements) {
        if (elements.size() != 9) {
            logger.error("Error: ", new IllegalArgumentExce(resourceBundle.getString("ValueBetween1and9")));
            throw new IllegalArgumentExce(resourceBundle.getString("ValueBetween1and9"));
        }
        this.elements = new ArrayList<>(elements);
    }

    public List<SudokuField> getElements() {
        List<SudokuField> sudokuFields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            sudokuFields.set(i, new SudokuField(elements.get(i).getFieldValue()));
        }
        return sudokuFields;
    }

    boolean isValid() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (elements.get(i).getFieldValue() == elements.get(j).getFieldValue()
                        || elements.get(i).getFieldValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public abstract SudokuElement clone();
}
