package ife.mp.lk.exeptions;

import java.io.Serializable;
import java.util.ListResourceBundle;

public class SerializableExceptionResource_pl  extends ListResourceBundle implements Serializable {

        /*------------------------ METHODS REGION ------------------------*/
        @Override
        protected Object[][] getContents() {
            return new Object[][]{
                    {"NoSolution", "Nie znaleziono rozwiÄ\u0085zania"},
                    {"ValueBetween1and9", "WartoÅ\u009BÄ\u0087 musi byÄ\u0087 miÄ\u0099dzy 1 i 9"},
                    {"NullError", "BÅ\u0082Ä\u0099dny null"}

            };
        }
}
