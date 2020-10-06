package myPackage;

/**
 * On this program we need to read from text file some url and write to file the URL and size of bytes.
 *
 * @author Batya Pollack
 */
public class Main {

    /**
     * @param args- the arguments we get from user
     */
    public static void main(String[] args) {

        try {
            Controller.getInstance().run(args);
        } catch (ArgumentsException e) {
            System.err.println(e.toString());
        } catch (BadInputException e) {
            System.err.println(e.toString());
        }
    }

}
