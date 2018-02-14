package aofa.permutation.generator;

import aofa.permutation.implementation.ArrayPermutation;

import java.util.Random;

/**
 * PermutationGenerator implements the Fisher-Yates algorithm.
 * It behaves like an iterator. The number of permutation to be generated is
 * defined on construction.
 * Also, a call to the random method replaces the former permutation in memory.
 * Therefore, one should make copies to obtain several permutation in the same time.
 */
public class PermutationGenerator extends aofa.RandomGeneratorSource<ArrayPermutation> {
    private ArrayPermutation buffer;
    private Random r;

    /**
     * Fisher-Yates algorithm.
     * Complexity: O(n).
     * @return a random permutation (uniform distribution over the permutation of the same size)
     */
    public ArrayPermutation random(){
        int i,tmp,pos,size=buffer.size();
        for(i=0;i<size;i++){
            pos=r.nextInt(size-i);
            buffer.swapValue(i,i+pos);
        }
        return buffer;
    }

    /**
     * PermutationGenerator construction. Defines of many permutations are going to be generated.
     * @param pNumber fixes the number of permutation to be generated
     * @param pSize fixes the size of the permutations to generate
     */
    public PermutationGenerator(int pNumber,int pSize){
        super(pNumber);
        buffer=ArrayPermutation.identity(pSize);
        r=new Random();
    }
}
