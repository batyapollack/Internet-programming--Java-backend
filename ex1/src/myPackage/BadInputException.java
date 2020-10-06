package myPackage;

import java.io.IOException;

import static myPackage.Macros.BAD_INPUT;

/**
 * myPackage.BadInputException- class that extends from IOException and Handles a myPackage.BadInputException thrown exception
 */
public class BadInputException extends IOException {
    @Override
    public String toString() {
        return BAD_INPUT;
    }
}
