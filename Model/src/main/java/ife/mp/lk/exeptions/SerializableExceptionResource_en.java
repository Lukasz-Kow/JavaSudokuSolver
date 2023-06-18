package ife.mp.lk.exeptions;

import java.io.Serializable;
import java.util.ListResourceBundle;

public class SerializableExceptionResource_en extends ListResourceBundle implements Serializable {

        /*------------------------ METHODS REGION ------------------------*/
        @Override
        protected Object[][] getContents() {
            return new Object[][]{
                    {"NoSolution", "No solution found"},
                    {"ValueBetween1and9", "Value must be between 1 and 9"},
                    {"NullError", "Null error"}
            };
        }
}
