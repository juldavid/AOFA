package test;

import aofa.InputSource;
import aofa.algorithm.AlgorithmSet;
import aofa.algorithm.sort.*;
import aofa.permutation.Permutation;
import aofa.permutation.generator.PermutationGenerator;
import aofa.permutation.implementation.ArrayPermutation;
import aofa.permutation.pattern.SetOfCyclesPatternAnalyzer;

import java.util.ArrayList;

public class Benchmark {
    public static void main(String [] args){
        InputSource<ArrayPermutation> is=new PermutationGenerator(10,10000);
        AlgorithmSet<Sort<Integer>> algorithmList=new AlgorithmSet<>();
        algorithmList.add("Bubble    Sort",new BubbleSort<>());
        algorithmList.add("Quick     Sort",new QuickSort<>());
        algorithmList.add("Selection Sort",new SelectionSort<>());
        algorithmList.add("Merge     Sort",new MergeSort<>());
        algorithmList.add("Insertion Sort",new InsertionSort<>());
        int gaps[]={701,301,132,57,23,10,4,1};
        algorithmList.add("Shell     Sort",new ShellSort<>(gaps));
        do{
            Permutation p = is.next();
            Permutation clone;
            for(String name:algorithmList.getAlgorithmsNames()){
                clone=p.clone();
                long startTime = System.nanoTime();
                algorithmList.getAlgorithm(name).sort(clone);
                long stopTime = System.nanoTime();
                long elapsedTime = stopTime - startTime;
                System.out.println(name+": "+elapsedTime+" "+clone.getCmpCounter()+" "+clone.getSwapCounter());
            }
            System.out.println("---------------------------------------------------------");
        }while (is.hasNext());
    }
}
