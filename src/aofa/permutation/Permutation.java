package aofa.permutation;

import aofa.algorithm.sort.AbstractSortable;
import aofa.permutation.implementation.ArrayPermutation;
import toolkit.ConsoleColors;

/**
 * A permutation is a famous combinatorial object.
 * A permutation of size n contains each value between 1 and n exactly once
 * in any order.
 */
public abstract class Permutation extends AbstractSortable<Integer> {
    /**
     * Constructor, defines the size of the permutation.
     * @param pSize is the size of the permutation
     */
    protected Permutation(int pSize) {
        super(pSize);
    }

    /**
     * Overloading of the equals method
     * @param o has to be a permutation
     * @return true if o and this are the same permutation.
     * @throws RuntimeException if o is not an instance of Permutation
     */
    @Override public boolean equals(Object o)throws RuntimeException{
        if(!(o instanceof Permutation))
            throw new RuntimeException("The object should be a Permutation");
        Permutation p=(Permutation)o;
        if(p.size()!=size) return false;
        int i=0;
        while(i<size){
            if(!this.getValue(i).equals(p.getValue(i)))
                return false;
            i++;
        }
        return true;
    }

    private String fromValueToSpaces(int value,int max){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<((int)Math.log10(max)-(int)Math.log10(value)+1);i++)
            sb.append(" ");
        return sb.toString();
    }
    /**
     * Overloading of the toString method
     * @return a String containing the whole permutation.
     */
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++) {
            if(i+1==this.getValue(i))
                sb.append(ConsoleColors.RED);
            sb.append(i+1);
            if(i+1==this.getValue(i))
                sb.append(ConsoleColors.RESET);
            sb.append(fromValueToSpaces(i+1,size));
        }
        sb.append("\n");
        for(int i=0;i<size;i++) {
            sb.append(this.getValue(i));
            sb.append(fromValueToSpaces(this.getValue(i),size));
        }
        return sb.toString();
    }

    public abstract Permutation clone();

}
