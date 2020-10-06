package myPackage;

import java.io.IOException;

import static myPackage.Macros.BAD_INPUT;
import static myPackage.Macros.CLOSE_INVALID;

/**
 * myPackage.FileCloseException-
 * class that extends from IOException and Handles a myPackage.FileCloseException thrown exception
 */
public class FileCloseException extends IOException {
    @Override
    public String toString() {
        return CLOSE_INVALID;
    }
}

