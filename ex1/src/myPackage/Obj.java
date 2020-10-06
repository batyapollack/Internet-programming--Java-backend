package myPackage;

import java.net.URL;

/**
 * myPackage.Obj : class the responsible to build the Object-(URL,size of bytes) for the list we build.
 * Data members: myURL- String that hold the URl.
 * : myCount- Integer the hold the size of bytes.
 */
public class Obj implements Comparable<Obj> {

    private String myURL;// String that hold the URl.
    private Integer myCount;// Integer the hold the size of bytes.

    public Integer getMyCount() {
        return myCount;
    }

    /**
     * Ctor that initialize data members
     *
     * @param url   - String that hold the URl.
     * @param count - Integer the hold the size of bytes.
     */
    // Ctor of myPackage.URLAndBytes
    Obj(URL url, Integer count) {

        this.myURL = url.toString();
        this.myCount = count;
    }

    @Override
    public String toString() {
        return myURL + " " + myCount.toString();
    }


    /**
     * Compare to - is comparator the compare between 2 myPackage.URLAndBytes
     *
     * @param obj -  the other  myPackage.URLAndBytes obj.
     * @return -Compares this object with the specified object for order.  Returns a
     * * negative integer, zero, or a positive integer as this object is less
     * * than, equal to, or greater than the specified object.
     */


    @Override
    public int compareTo(Obj obj) {
        int number = obj.getMyCount();
        /* For Ascending order*/
        return this.myCount - number;
    }
}
