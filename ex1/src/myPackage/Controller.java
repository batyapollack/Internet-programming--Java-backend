package myPackage;

import java.io.*;
import java.util.*;

import static myPackage.Macros.*;


/**
 * myPackage.Controller -handle the program
 * functions: run and countArgs
 */

public class Controller {

    private static Controller single_instance; /** instance of controller for singleton */
    /**
     * Functions: run- run the program.
     * :countArgs- check if the count args is correct
     * Data members: myList- hold the list (Url,size of bytes)
     */
    private ArrayList<Obj> myList;


    public Controller() {
        this.myList = new ArrayList<>();
    }


    /**
     * This function run the program
     *
     * @param args - arguments from user
     * @throws BadInputException  - Exception that thrown if we not succeed to read from file.
     * @throws ArgumentsException -Exception that thrown if count args not equal to 2.
     */
    public void run(String[] args) throws BadInputException, ArgumentsException {
        try {

            if (args.length != SIZE_OF_ARGS) {
                throw new ArgumentsException();
            }

            GetDataInterface w = new ReadFromFile(args[IN]);
            CreateArrayObj rw = new CreateArrayObj(w, myList);//ctor
            rw.createList();// create the list
            Collections.sort(myList);// sort the list

            WriteToFile writeToFile = new WriteToFile(args[OUT], myList);
            writeToFile.perform();

        } catch (FileNotFoundException e) {
            throw new BadInputException();
        } catch (WriteFileException e) {
            System.err.println(e.toString());
        } catch (FileCloseException e) {
            System.err.println(e.toString());
        }


    }

    public static Controller getInstance() {
        if (single_instance == null)
            single_instance = new Controller();

        return single_instance;
    }


}




