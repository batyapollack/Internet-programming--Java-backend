package myPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static myPackage.Macros.*;


/**
 * myPackage.CreateArrayObj - class that build ArrayList of valid url with num of bytes
 * Data members:
 * instanceImplement - myPackage.WordSupplier type
 * input - InputStream type that read from file
 * url - URL type that get from curr line
 * myList - ArrayList type that put url and number of bytes if url is valid
 */
public class CreateArrayObj {

    //-----------Data-members--------------------------------
    private InputStream input = null;
    private URL url = null;
    private List<Obj> objList;
    private GetDataInterface instanceImplement;
    //-------------------------------------------------------

    /**
     * Ctor that Initializes data members.
     *
     * @param instanceImplement - myPackage.WordSupplier type .
     * @param objList           - ArrayList type that put url and number of bytes if url is valid.
     */
    public CreateArrayObj(GetDataInterface instanceImplement, ArrayList<Obj> objList) {
        this.instanceImplement = instanceImplement;
        this.objList = new ArrayList<Obj>();
        this.objList = objList;
    }

    /**
     * Function that build list of url and number of bytes if task is successful.
     *
     * @throws FileNotFoundException - thrown if file not found.
     */
    public void createList() throws FileNotFoundException {
        ArrayList<String> myFile = instanceImplement.getData();
        for (String cell : myFile) {
            try {
                URLValidity(cell);
                objList.add(new Obj(url, byteValidity()));
            } catch (URLException e) {
                System.err.println(e.toString());
            } catch (OpenStreamException e) {
                System.err.println(e.toString());
            }
        }
    }

    /**
     * Function that check if url is valid.
     * (like server fallen and etc..).
     *
     * @return count - int type that hold count of bytes of url.
     */
    private int byteValidity() {
        int count = ZERO;
        try {
            while ((input.read()) != INVALID)
                count++;
        } catch (IOException e) {

            count = ZERO;
            System.err.println(FAIL);
        }
        return count;
    }


    /**
     * @param currLine -  String  that indicate the current line on file.
     * @throws URLException        - Exception that thrown if there is URL is wrong.
     * @throws OpenStreamException -Exception that thrown if there is open stream is fail.
     */
    private void URLValidity(String currLine) throws URLException, OpenStreamException {

        try {
            url = new URL(currLine); //MalformedURLException
            input = url.openStream(); // IOException
        } catch (MalformedURLException e)//if URL not success
        {
            throw new URLException();
        } catch (IOException e)//
        {
            throw new OpenStreamException();
        }
    }


}