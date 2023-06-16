package ife.mp.lk;

import ife.mp.lk.exeptions.ComparisonExce;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ResourceBundle;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {
    private int value;

    public SudokuField(int value) {
        this.value = value;
    }

    public int getFieldValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("errors");
    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);



    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SudokuField)) {
            return false;
        }
        SudokuField other = (SudokuField) obj;
        return new EqualsBuilder()
                .append(value, other.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("value", value)
                .toString();
    }

    @Override
    public SudokuField clone() {
        return new SudokuField(getFieldValue());

    }

    @Override
    public int compareTo(SudokuField o) {
        if (o == null) {
            logger.error("Error: ", new ComparisonExce(resourceBundle.getString("NullError")));
            throw new ComparisonExce(resourceBundle.getString("NullError"));
        }
        return Integer.compare(this.value, o.getFieldValue());
    }
}
