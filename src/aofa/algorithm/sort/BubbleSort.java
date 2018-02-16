package aofa.algorithm.sort;

/**
 * BubbleSort Algorithm.
 * Time Complexity: O(n^2) in the worst-case scenario, O(n) in the best-case scenario.
 * Space Complexity: O(1)
 * @param <T> is the type of value we want to sort.
 */
public class BubbleSort<T> implements Sort<T> {

    /**
     * BubbleSort Algorithm.
     * Time Complexity: O(n^2) in the worst-case scenario, O(n) in the best-case scenario.
     * Space Complexity: O(1)
     * The algorithm is the most efficient when the data is almost already sorted.
     * @param data is the data to Sort. Has to be a Sortable.
     */
    @Override
    public void sort(Sortable<T> data) {
        boolean stop=false;
        int i,size=data.size();
        while(!stop){
            stop=true;
            for(i=1;i<size;i++)
                if (data.compare(i-1, i) > 0) {
                    data.swap(i-1,i);
                    stop = false;
                }
        }
    }
}
