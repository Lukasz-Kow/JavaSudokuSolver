package ife.mp.lk.exeptions;

import java.io.Serializable;
import java.util.ListResourceBundle;

public class SerializableExceptionResource_pl  extends ListResourceBundle implements Serializable {

        /*------------------------ METHODS REGION ------------------------*/
        @Override
        protected Object[][] getContents() {
            return new Object[][]{
                    {"NoSolution", "Nie znaleziono rozwiÄ\u0085zania"},
                    {"ValueBetween1and9", "Ilosc elementow musi byc miedzy 1 i 9"},
                    {"ValueMustBe9", "Ilosc elementow musi byc 9"},
                    {"NullError", "BÅ\u0082Ä\u0099dny null"}

            };
        }
}
