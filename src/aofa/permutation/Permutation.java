package aofa.permutation;

import aofa.algorithm.sort.AbstractSortable;
import aofa.permutation.implementation.ArrayPermutation;

public abstract class Permutation extends AbstractSortable<Integer> {
    protected Permutation(int pSize) {
        super(pSize);
    }

    @Override public abstract boolean equals(Object p);
    @Override public abstract String toString();


}
