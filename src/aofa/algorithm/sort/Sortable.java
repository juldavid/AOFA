package aofa.algorithm.sort;

public interface Sortable<T> {
    int size();
    T getValue(int pos);
    void setValue(int pos,T value);
    int compare(int pos1,int pos2);
    void swap(int pos1,int pos2);
}
