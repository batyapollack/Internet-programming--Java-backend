package myPackage;

import java.io.IOException;

import static myPackage.Macros.WRONG_ARGS;

/**
 * myPackage.ArgumentsException- class that extends from IOException and Handles a myPackage.ArgumentsException thrown exception
 */
public class ArgumentsException extends IOException {
    @Override
    public String toString() {
        return WRONG_ARGS;
    }
}
