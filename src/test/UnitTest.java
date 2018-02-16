package test;

import aofa.InputSource;
import aofa.permutation.Permutation;
import aofa.permutation.generator.PermutationGenerator;
import aofa.permutation.implementation.ArrayPermutation;
import aofa.algorithm.sort.*;
import aofa.permutation.pattern.SetOfCyclesPatternAnalyzer;
import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;


class UnitTest {
    private void sort(Sort<Integer> algo){
        int size=40;
        InputSource<ArrayPermutation> is=new PermutationGenerator(10,size);
        Permutation id=ArrayPermutation.identity(size);
        do{
            Permutation p = is.next();
            algo.sort(p);
            assertEquals(p,id);
        }while (is.hasNext());
    }

    @Test
    void selection(){
        Sort<Integer> algo=new SelectionSort<>();
        sort(algo);
    }
    @Test
    void bubble(){
        Sort<Integer> algo=new BubbleSort<>();
        sort(algo);
    }
    @Test
    void insertion(){
        Sort<Integer> algo=new InsertionSort<>();
        sort(algo);
    }

    @Test
    void shell(){
        int gaps[]={11,5,3,1};
        Sort<Integer> algo=new ShellSort<>(gaps);
        sort(algo);
    }
    @Test
    void merge(){
        Sort<Integer> algo=new MergeSort<>();
        sort(algo);
    }
    @Test
    void quick(){
        Sort<Integer> algo=new QuickSort<>();
        sort(algo);
    }


    /*@Test
    void setOfCycles(){
        int size=50;
        Permutation id=ArrayPermutation.identity(size);
        SetOfCyclesPatternAnalyzer socpa=new SetOfCyclesPatternAnalyzer();
        //socpa.computeSetOfCycles(id);
        //assertEquals(socpa.numberOfCycles(),size);
        //assertEquals(socpa.fixedPoints(),size);
    }*/

}
