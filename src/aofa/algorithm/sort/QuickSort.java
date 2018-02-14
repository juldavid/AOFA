package aofa.algorithm.sort;

import java.util.function.Function;

public class QuickSort<T> extends Sort<T> {
    private Function<Integer,Integer> choosePivot= n -> n-1;

    public void setPivotChoice(Function<Integer,Integer> f){
        choosePivot=f;
    }

    private int partitioner(Sortable<T> data,int start,int n){
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

    private void quicksort(Sortable<T> data,int start, int n){
        if(n>1){
            int pivot=partitioner(data,start,n);
            quicksort(data,start,pivot-start);
            quicksort(data,pivot+1,n-(pivot+1-start));
        }
    }

    @Override
    public void sort(Sortable<T> data) {
        quicksort(data,0,data.size());
    }
}
