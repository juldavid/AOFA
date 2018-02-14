package aofa.algorithm.sort;

public abstract class AbstractSortable<T> implements Sortable<T>{
    protected int size;
    private int cmpCounter;
    private int swapCounter;

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
