package hac;
import java.util.ArrayList;

/**
 * class ArraySavedResults - save the global array that contains for all cell object of AnswerAndCount
 */
public class ArraySavedResults
{
    private static ArraySavedResults arraySavedResults;
    private ArrayList<PairOfAnswerCount.AnswerAndCount> mList;

    /**
     * ctor of ArraySavedResults that create ArrayList
     */
    public ArraySavedResults()
    {
        mList = new ArrayList<>();
    }

    /** function that return the only object of arraySavedResults
     * @return arraySavedResults - instance of ArraySavedResults
     */
    public static ArraySavedResults getInstance()
    {
        if(arraySavedResults== null)
            arraySavedResults = new ArraySavedResults();
        return  arraySavedResults;
    }

    /**
     * function that add obj to list
     * @param v - AnswerAndCount type
     */
    public void addIndex(PairOfAnswerCount.AnswerAndCount v){mList.add(v);}

    /**
     * synchronized function that set count of index from array list
     * @param index - i from arrayList
     */
    public synchronized void setCountOfIndex(int index ){mList.get(index).setCount(mList.get(index).getCount()+1); }

    /**
     *
     * @param index - i from arrayList
     * @return count of voted of specific answer
     */
    public synchronized int getCountByIndex(int index){return mList.get(index).getCount();}

    /**
     * @param index- i from arrayList
     * @return  answer of specific index
     */
    public  String getAnswerByIndex(int index){return mList.get(index).getAnswer();}

    /**
     * function that return size of arrayList
     * @return size of arrayList
     */
    public int getSizeList(){return mList.size();}

}