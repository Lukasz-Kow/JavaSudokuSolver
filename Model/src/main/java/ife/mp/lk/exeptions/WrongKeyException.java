package ife.mp.lk.exeptions;

public class WrongKeyException extends Exception {

        public WrongKeyException(final String message, Throwable cause) {
            super(message, cause);
        }

        public WrongKeyException(final String message) {
            super(message);
        }


}
