package ife.mp.lk;

public class CustomStringConverter extends javafx.util.StringConverter<Integer> {

    public String toString(Integer integer) {
        if (integer == null || integer.intValue() == 0) {
            return "";
        }
        return integer.toString();
    }

    public Integer fromString(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(string);
    }
}
