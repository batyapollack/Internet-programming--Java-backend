package myPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static myPackage.Macros.*;


/**
 * myPackage.WriteToFile -write to file.
 * Data members: outputFile- the name of file that we write to him.
 * :myList - list that hold (URL,size of bytes)) we build.
 */
public class WriteToFile {
    private String outputFile;// the name of file that we write to him.
    private ArrayList<Obj> myList;//list that hold (URL,size of bytes)) we build.

    /**
     * Ctor that initialize the data members
     *
     * @param outputFile- the name of file that we write to him.
     * @param myList      - list that hold (URL,size of bytes)) we build.
     */
    WriteToFile(String outputFile, ArrayList<Obj> myList) {
        this.outputFile = outputFile;
        this.myList = myList;
    }

    /**
     * perform - function that try write to file output.
     * catch IOException - if  close file not successful / Write not succeed.
     */
    public void perform() throws FileCloseException, WriteFileException {
        FileWriter writeFile = null;
        try {
            writeFile = new FileWriter(outputFile);
            for (Obj urlAndBytes : myList) {
                writeFile.write(urlAndBytes.toString());
                writeFile.append("\n");
                writeFile.flush();
            }
        } catch (IOException e) {
            throw new WriteFileException();
        } finally {
            try {
                assert writeFile != null;
                writeFile.close();
            } catch (IOException e) {
                throw new FileCloseException();
            }
        }

    }
}
