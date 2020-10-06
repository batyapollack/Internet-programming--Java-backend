package myPackage;


import static myPackage.Macros.URl_INVALID;

/**
 * myPackage.URLException- class that extends from IOException and Handles a myPackage.URLException thrown exception
 */
public class URLException extends Exception {
    @Override
    public String toString() {
        return URl_INVALID;
    }
}
