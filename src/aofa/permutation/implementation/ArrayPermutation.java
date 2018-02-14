package aofa.permutation.implementation;


import aofa.permutation.Permutation;

public class ArrayPermutation extends Permutation{
    private int [] permutation;

    private ArrayPermutation(int pSize){
        super(pSize);
        permutation=new int[pSize];
    }

    @Override public boolean equals(Object o)throws RuntimeException{
        if(!(o instanceof Permutation))
            throw new RuntimeException("The object should be a Permutation");
        Permutation p=(Permutation)o;
        if(p.size()!=size) return false;
        int i=0;
        while(i<size){
            if(permutation[i]!=p.getValue(i))
                return false;
            i++;
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++) {
            sb.append(permutation[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public void setValue(int pos,Integer value)throws RuntimeException{
        if(pos<0 || pos>=size)
            throw new RuntimeException("Out of range");
        permutation[pos]=value;
    }

    public Integer getValue(int pos)throws RuntimeException{
        if(pos<0 || pos>=size)
            throw new RuntimeException("Out of range");
        return permutation[pos];
    }

    public int compareValue(int pos1,int pos2){
        return permutation[pos1]-permutation[pos2];
    }

    public void swapValue(int pos1,int pos2){
        int tmp=permutation[pos1];
        permutation[pos1]=permutation[pos2];
        permutation[pos2]=tmp;
    }

    public static ArrayPermutation identity(int pSize){
        ArrayPermutation res=new ArrayPermutation(pSize);
        for(int i=0;i<pSize;i++)
            res.setValue(i,i+1);
        return res;
    }

}
