package ife.mp.lk;

import java.util.ListResourceBundle;

public class AuthorsSet_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"author_1"}, {"Mateusz Pryl"},
                {"author_2"}, {"Łukasz Kowalczyk"},
        };
    }

    public String toString() {
        String outString = new String();

        Object[][] temp = getContents();

        outString += (String) temp[0][0];
        outString += ": ";
        outString += (String) temp[0][1];
        outString += (String) temp[1][0];
        outString += ": ";
        outString += (String) temp[1][1];

        return outString;
    }
}
