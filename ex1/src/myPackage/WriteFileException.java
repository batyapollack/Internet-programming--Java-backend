package myPackage;

import java.io.IOException;

import static myPackage.Macros.WRITE_INVALID;

/**
 * myPackage.WriteFileException- class that extends from IOException
 * and Handles a myPackage.WriteFileException thrown exception
 */
public class WriteFileException extends IOException {
    @Override
    public String toString() {
        return WRITE_INVALID;
    }
}
