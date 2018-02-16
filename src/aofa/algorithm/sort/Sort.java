package aofa.algorithm.sort;

/**
 * Interface defining how to use a sorting algorithm.
 * @param <T>
 */
public interface Sort<T> {
    /**
     * Generic method to sort a data.
     * @param data is the data to Sort. Has to be a Sortable.
     */
    void sort(Sortable<T> data);
}
