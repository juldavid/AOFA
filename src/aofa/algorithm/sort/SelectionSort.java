package aofa.algorithm.sort;

/**
 * Selection Sort.
 * Time Complexity: O(n^2) in all cases.
 * Space Complexity: O(1)
 * @param <T> is the type of value we want to sort.
 */
public class SelectionSort<T> implements Sort<T> {
    /**
     * Find the position of the smallest value in the Sortable between the position pos and the last value.
     * Time Complexity: O(n)
     * @param data is the data in which we're looking.
     * @param pos is the position at which we want to starting looking.
     * @return the position of the smallest value between pos and the last.
     */
    private int findMinPosition(Sortable<T> data,int pos){
        int i,posMin=pos;
        for(i=pos+1;i<data.size();i++){
            if(data.compare(i,posMin)<0)
                posMin=i;
        }
        return posMin;

    }

    /**
     * Selection Sort.
     * Time Complexity: O(n^2) in all cases.
     * Space Complexity: O(1)
     * @param data is the data to Sort. Has to be a Sortable.
     */
    @Override
    public void sort(Sortable<T> data) {
        int i;
        int posMin;
        for(i=0;i<data.size();i++){
            posMin=findMinPosition(data,i);
            data.swap(i,posMin);
        }
    }
}
