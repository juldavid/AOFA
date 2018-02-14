package aofa.algorithm.sort;

public class BubbleSort<T> extends Sort<T> {


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
