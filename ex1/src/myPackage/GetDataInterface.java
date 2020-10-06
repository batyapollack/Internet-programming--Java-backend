package myPackage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * myPackage.GetDataInterface - interface that define function getWords() that throws FileNotFoundException.
 */
public interface GetDataInterface {

    ArrayList<String> getData() throws FileNotFoundException;
}
