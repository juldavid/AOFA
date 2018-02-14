package aofa.algorithm.sort;

public class ShellSort<T> extends Sort<T>{
    private int gaps[];

    public ShellSort(int[] pGaps) throws RuntimeException{
        if(pGaps[pGaps.length-1]!=1)
            throw new RuntimeException("The last gap has to be 1");
        gaps=pGaps;
    }

    @Override
    public void sort(Sortable<T> data) {
        int i;
        for(i=0;i<gaps.length;i++)
            InsertionGapSort.gapSort(data,gaps[i]);
    }

}
