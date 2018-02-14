package test;

import aofa.algorithm.sort.QuickSort;
import aofa.algorithm.sort.Sort;
import aofa.InputSource;
import aofa.permutation.Permutation;
import aofa.permutation.generator.PermutationGenerator;
import aofa.permutation.implementation.ArrayPermutation;

public class Test {
    public static void main(String [] args){
        InputSource<ArrayPermutation> is=new PermutationGenerator(1,50);
        Sort<Integer> algo=new QuickSort<>();
        do{
            Permutation p = is.next();
            System.out.println(p);
            algo.sort(p);
            System.out.println(p);
        }while (is.hasNext());
    }
}
