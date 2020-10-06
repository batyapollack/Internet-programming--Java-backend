package myPackage;

public class Macros {

    //----------int----------------------------------
    public static final int SIZE_OF_ARGS = 2;/** size of arguments from input user*/
    public static final int IN = 0;/** location of input file*/
    public static final int OUT = 1;/** location of output file*/
    public static final int ZERO=0;/** zero*/
    public static final int INVALID= -1;/** if read from file invalid*/
    //------------------strings-------------------------
    public static final String BAD_INPUT="BadInputException- Bad input"; /** for exception BadInputException*/
    public static final String FAIL = "Server fallen"; /** for exception when server fallen*/
    public static final String WRONG_ARGS ="ArgumentsException- Wrong usage"; /** for exception ArgumentsException*/
    public static final String WRITE_INVALID =   "Write not succeed";  /** for exception when Write not succeed*/
    public static final String CLOSE_INVALID =  "close not success";/** for exception when close file not success*/
    public static final String OPEN_STREAM = "OpenStreamException-openStream not success"; /** for exception OpenStreamException*/
    public static final String URl_INVALID = "URLException-URL not success"; /** for exception URLException*/

}
