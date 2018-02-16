package aofa.algorithm.sort;

/**
 * Insertion Sort.
 * Time Complexity: O(n^2) in the worst case, O(n) in the bast case.
 * @param <T> is the type of value we want to sort.
 */
public class InsertionSort<T> implements Sort<T>{
    /**
     * Insertion Sort.
     * Time Complexity: O(n^2) in the worst case, O(n) in the bast case.
     * @param data is the data to Sort. Has to be a Sortable.
     */
    @Override
    public void sort(Sortable<T> data) {
        InsertionGapSort.gapSort(data,1);
    }
}
