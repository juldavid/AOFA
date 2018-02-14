package aofa.algorithm.sort;

public class SelectionSort<T> extends Sort<T> {
    private int findMinPosition(Sortable<T> data,int pos){
        int i,posMin=pos;
        for(i=pos+1;i<data.size();i++){
            if(data.compare(i,posMin)<0)
                posMin=i;
        }
        return posMin;

    }

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
