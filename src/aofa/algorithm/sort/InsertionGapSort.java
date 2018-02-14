package aofa.algorithm.sort;

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
