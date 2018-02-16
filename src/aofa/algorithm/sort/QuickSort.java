package aofa.algorithm.sort;

import java.util.function.Function;

/**
 * A generic implementation of the Quicksort algorithm.
 * How to choose the pivot can be parametered using choosePivot.
 * Time Complexity: O(n^2) in the worst-case, O(n log(n)) in the best case and in average.
 * Space Complexity: O(n) in the worst-case, O(log(n)) in the best case and in average.
 * The algorithm is the most efficient when the data is shuffled.
 * @param <T> is the type of value we want to sort.
 */
public class QuickSort<T> implements Sort<T> {
    private Function<Integer,Integer> choosePivot= n -> n-1;

    /**
     * Modifies how the pivot is choosen.
     * @param f is the function that will be used to choose the pivot.
     */
    public void setPivotChoice(Function<Integer,Integer> f){
        choosePivot=f;
    }

    /**
     * Partitions a fragment of a sortable in to part: values that are smaller or equal than the pivot
     * are put on its left and values that are greater on its right.
     * @param data is the data we want to sort.
     * @param start is the position of the beginning of the fragment we want to partition.
     * @param n is the size of the fragment.
     * @return the position of the pivot after the partition has been made.
     */
    private int partition(Sortable<T> data, int start, int n){
        int i,j,last=start+n-1;
        data.swap(last,start+this.choosePivot.apply(n));
        for(i=start,j=start;i<last;i++){
            if(data.compare(i,last)<=0){
                data.swap(i,j);
                j++;
            }
        }
        if(data.compare(j,last)>0)
            data.swap(j,last);
        return j;
    }

    /**
     * Main part of the algorithm.
     * Calls the partition method then call itself again on the two smaller fragments.
     * @param data is the data we want to sort
     * @param start is the position of the beginning of the fragment we want to sort
     * @param n is the size of the fragment.
     */
    private void quicksort(Sortable<T> data,int start, int n){
        if(n>1){
            int pivot= partition(data,start,n);
            quicksort(data,start,pivot-start);
            quicksort(data,pivot+1,n-(pivot+1-start));
        }
    }

    /**
     * Quicksort algorithm.
     * Time Complexity: O(n^2) in the worst-case, O(n log(n)) in the best case and in average.
     * Space Complexity: O(n) in the worst-case, O(log(n)) in the best case and in average.
     * @param data is the data to Sort. Has to be a Sortable.
     */
    @Override
    public void sort(Sortable<T> data) {
        quicksort(data,0,data.size());
    }
}
