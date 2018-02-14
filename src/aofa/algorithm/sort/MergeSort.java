package aofa.algorithm.sort;

public class MergeSort<T> extends Sort<T> {
    private Object[] buffer;
    private int size=0;

    private void setSize(int pSize){
        if(pSize>size) {
            buffer=new Object[pSize];
            size=pSize;
        }
    }

    private void merge(Sortable<T> data,int start,int n,int l){
        int i=0,j=l,k=0;
        while(i<l&&j<n){
            if(data.compare(start+i,start+j)>0)
                buffer[k++]=data.getValue(start+j++);
            else
                buffer[k++]=data.getValue(start+i++);
        }
        while(i<l)
            buffer[k++]=data.getValue(start+i++);
        while(j<n)
            buffer[k++]=data.getValue(start+j++);
        for(i=0;i<n;i++)
            data.setValue(start+i,(T)buffer[i]);
    }

    private void mergeSort(Sortable<T> data,int start,int n){
        if(n>1){
            mergeSort(data,start,n/2);
            mergeSort(data,start+n/2,n-n/2);
            merge(data,start,n,n/2);
        }
    }


    @Override
    public void sort(Sortable<T> data) {
        if(data.size()>size)
            setSize(data.size());
        mergeSort(data,0,data.size());
    }
}
