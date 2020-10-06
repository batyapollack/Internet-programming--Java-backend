package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * myPackage.ReadFromFile - class that read data from file and write to arrayList of string
 * Data members:
 * fileRead - ArrayList contains each cell - is a row in the file
 * input -The file name from which we read the data
 * reader - for Scanner
 */

public class ReadFromFile implements GetDataInterface {

    private Scanner reader = null;
    private ArrayList<String> fileRead;
    private String input;


    /**
     * Ctor that initializes data members
     *
     * @param input- The file name from which we read the data
     */
    ReadFromFile(String input) {
        this.input = input;
        this.fileRead = new ArrayList<String>();
    }

    /**
     * Function that read data from file and input all rows to Arraylist
     *
     * @return myFile - return the Arraylist that contains all rows from file
     * @throws FileNotFoundException - If the scanner fails the exception is thrown
     */
    @Override
    public ArrayList<String> getData() throws FileNotFoundException {
        File myReadFile = new File(input);
        reader = new Scanner(myReadFile);
        while (reader.hasNextLine())
            fileRead.add(reader.nextLine());
        reader.close();
        return fileRead;
    }
}
