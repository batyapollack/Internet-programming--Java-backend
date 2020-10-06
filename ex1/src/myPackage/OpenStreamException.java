package myPackage;

import java.io.IOException;

import static myPackage.Macros.OPEN_STREAM;

/**
 * myPackage.OpenStreamException- class that extends from IOException
 * and Handles a myPackage.OpenStreamException thrown exception
 */
public class OpenStreamException extends IOException {
    @Override
    public String toString() {
        return OPEN_STREAM;
    }
}
