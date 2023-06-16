package ife.mp.lk.exeptions;

public class ClassNotFoundError extends ClassNotFoundException {

        public ClassNotFoundError(String message) {
            super(message);
        }

        public ClassNotFoundError(String message, Throwable cause) {
            super(message, cause);
        }

}
