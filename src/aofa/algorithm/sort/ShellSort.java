package aofa.algorithm.sort;

/**
 * Shell Sort.
 * Time Complexity: O(n^2) in the worst case, O(n) in the bast case.
 * This algorithm is supposed to improve Insertion Sort by moving elements
 * in a faster way using the 'gaps'.
 * Depends on the list of gaps given as an input.
 * @param <T> is the type of value we want to sort.
 */
public class ShellSort<T> implements Sort<T>{
    private int gaps[];

    /**
     * Initializes the gaps that will be used
     * @param pGaps is the array of gaps that will be applied, last one should be 1.
     * @throws RuntimeException if the last gap isn't equal to 1, which garanties that the algorithm works.
     */
    public ShellSort(int[] pGaps) throws RuntimeException{
        if(pGaps[pGaps.length-1]!=1)
            throw new RuntimeException("The last gap has to be 1");
        gaps=pGaps;
    }

    /**
     * Shell Sort.
     * Time Complexity: O(n^2) in the worst case, O(n) in the bast case.
     * This algorithm is supposed to improve Insertion Sort by moving elements
     * in a faster way using the 'gaps'.
     * Depends on the list of gaps given as an input.
     * @param data is the data to Sort. Has to be a Sortable.
     */
    @Override
    public void sort(Sortable<T> data) {
        int i;
        for(i=0;i<gaps.length;i++)
            InsertionGapSort.gapSort(data,gaps[i]);
    }

}
