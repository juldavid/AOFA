package aofa.algorithm.sort;

/**
 * The Sortable interface all the method that are necessary to be used by a sorting algorithm.
 * @param <T> is the type of values we want to sort.
 */
public interface Sortable<T> {
    /**
     * Returns the size of the combinatorial object.
     * @return the size of the combinatorial object.
     */
    int size();

    /**
     * Get a value at a given position.
     * @param pos is the position of the value we want to get.
     * @return the value at position pos.
     */
    T getValue(int pos);
    /**
     * Modifies the value at position pos
     * @param pos is the position of the value we want to modify
     * @param value is the new value.
    */
    void setValue(int pos,T value);
    /**
     * Compare two values in the Sortable object.
     * @param pos1 is the position of the first value
     * @param pos2 is the position of the second value
     * @return the difference between the first and the second value.
     */
    int compare(int pos1,int pos2);
    /**
     * Swap two values in the Sortable Object.
     * @param pos1 is the position of the first value
     * @param pos2 is the position of the second value
     */
    void swap(int pos1,int pos2);
}
