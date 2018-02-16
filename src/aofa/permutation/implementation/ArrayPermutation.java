package aofa.permutation.implementation;


import aofa.permutation.Permutation;

/**
 * In this implementation, Permutations are stored as an array of integer.
 * Constructor is private.
 * An ArrayPermutation can be obtained either with the identity method, or using an InputSource.
 */
public class ArrayPermutation extends Permutation{
    private int [] permutation; //stores the permutation

    /**
     * Contructor, initialize the array.
     * @param pSize is the array's size and therefore the permutation's size.
     */
    private ArrayPermutation(int pSize){
        super(pSize);
        permutation=new int[pSize];
    }



    /**
     * Modifies the value at position pos
     * @param pos is the position of the value we want to modify
     * @param value is the new value.
     * @throws RuntimeException if pos is out of bound.
     */
    public void setValue(int pos,Integer value)throws RuntimeException{
        if(pos<0 || pos>=size)
            throw new RuntimeException("Out of range");
        permutation[pos]=value;
    }

    /**
     * Get a value at a given position.
     * @param pos is the position of the value we want to get.
     * @return the value at position pos.
     * @throws RuntimeException if pos is out of bound.
     */
    public Integer getValue(int pos)throws RuntimeException{
        if(pos<0 || pos>=size)
            throw new RuntimeException("Out of range");
        return permutation[pos];
    }

    /**
     * Compare two values in the permutation.
     * @param pos1 is the position of the first value
     * @param pos2 is the position of the second value
     * @return the difference between the first and the second value.
     */
    public int compareValue(int pos1,int pos2){
        return permutation[pos1]-permutation[pos2];
    }

    /**
     * Swap two values in the permutation.
     * @param pos1 is the position of the first value
     * @param pos2 is the position of the second value
     */
    public void swapValue(int pos1,int pos2){
        int tmp=permutation[pos1];
        permutation[pos1]=permutation[pos2];
        permutation[pos2]=tmp;
    }

    /**
     * Returns a permutation equal to the identity, that is "1 2 3 4 ... pSize".
     * @param pSize is the size of the permutation.
     * @return the identity permutation of size pSize.
     */
    public static ArrayPermutation identity(int pSize){
        ArrayPermutation res=new ArrayPermutation(pSize);
        for(int i=0;i<pSize;i++)
            res.setValue(i,i+1);
        return res;
    }

    @Override
    public boolean equals(Object o){
        System.out.println("test");
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int hash=0;
        for(int i=0;i<10;i++)
            hash+=hash*permutation.length+permutation[i];
        return hash;
    }

    @Override
    public Permutation clone(){
        ArrayPermutation res=new ArrayPermutation(this.size);
        for(int i=0;i<this.size;i++)
            res.setValue(i,this.getValue(i));
        return res;
    }

}
