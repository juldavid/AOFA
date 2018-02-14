package aofa.algorithm.sort;

public class InsertionSort<T> extends Sort<T>{
    @Override
    public void sort(Sortable<T> data) {
        InsertionGapSort.gapSort(data,1);
    }
}
