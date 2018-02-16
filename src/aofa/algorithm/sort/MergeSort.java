package aofa.algorithm.sort;

/**
 * Merge Sort
 * Time complexity: O(n log n).
 * Space complexty: O(n).
 * @param <T> is the type of value we want to sort.
 */
public class MergeSort<T> implements Sort<T> {
    private Object[] buffer; //buffer that will be used to merge two fragments of a Sortable.

    private void setBufferSize(int pSize){
        buffer=new Object[pSize];
    }

    /**
     * Takes two sorted fragments of a sortable and merge them into a sorted larger fragment.
     * @param data is the data we want to sort
     * @param start the begining of the first fragment
     * @param n the size of both fragments.
     * @param l the position of the second fragment.
     */
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

    /**
     * Main algorithm. First partitions the data into two parts equally long, sorts them, then merges them.
     * @param data is the data we want to sort.
     * @param start the begining of the fragment
     * @param n the size of the fragment.
     */
    private void mergeSort(Sortable<T> data,int start,int n){
        if(n>1){
            mergeSort(data,start,n/2);
            mergeSort(data,start+n/2,n-n/2);
            merge(data,start,n,n/2);
        }
    }

    /**
     * Merge Sort
     * Time complexity: O(n log n).
     * Space complexty: O(n).
     * @param data is the data to Sort. Has to be a Sortable.
     */
    @Override
    public void sort(Sortable<T> data) {
        if(buffer==null || data.size()> buffer.length)
            setBufferSize(data.size());
        mergeSort(data,0,data.size());
    }
}
