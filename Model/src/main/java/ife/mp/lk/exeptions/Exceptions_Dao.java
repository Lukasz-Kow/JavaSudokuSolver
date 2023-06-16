package ife.mp.lk.exeptions;

public class Exceptions_Dao extends RuntimeException {

    public Exceptions_Dao(String message) {
        super(message);
    }

    public Exceptions_Dao(String message, Throwable cause) {
        super(message, cause);
    }

    public Exceptions_Dao(Throwable cause) {
        super(cause);
    }


}
