package ife.mp.lk.exeptions;

import java.io.IOException;

public class LoadingSudokuError extends IOException {

    public LoadingSudokuError(String message) {
        super(message);
    }

    public LoadingSudokuError(String message, Throwable cause) {
        super(message, cause);
    }
}
