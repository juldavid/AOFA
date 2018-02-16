package aofa.algorithm.sort;

/**
 * Abstract class which implements the Sortable interface.
 * Allows to compute how much comparing and swapping are made by an algorithm.
 * @param <T> is the type of value we want to sort.
 */
public abstract class AbstractSortable<T> implements Sortable<T>{
    protected int size;
    private int cmpCounter;
    private int swapCounter;

    public int getSwapCounter() {
        return swapCounter;
    }


    public int getCmpCounter() {
        return cmpCounter;
    }

    protected AbstractSortable(int pSize){
        size=pSize;
    }
    public int size(){
        return size;
    }
    protected abstract int compareValue(int pos1,int pos2);
    public int compare(int pos1,int pos2){
        cmpCounter++;
        return compareValue(pos1,pos2);
    }
    protected abstract void swapValue(int pos1,int pos2);
    public void swap(int pos1,int pos2){
        swapCounter++;
        swapValue(pos1,pos2);
    }

}
