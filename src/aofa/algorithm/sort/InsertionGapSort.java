package aofa.algorithm.sort;

/**
 * Static method which will be used by both InsertionSort and ShellSort.
 * Time Complexity: O(n^2/gap) in the worst case, O(n/gap) in the bast case.
 */
interface InsertionGapSort {
    static void gapSort(Sortable data, int gap){
        int i,j;
        for(i=gap;i<data.size();i++){
            j=i;
            while(j>=gap && data.compare(j,j-gap)<0){
                data.swap(j,j-gap);
                j-=gap;
            }
        }
    }

}
