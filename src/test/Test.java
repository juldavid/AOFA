package test;

import aofa.AnalysisCollector;
import aofa.InputSource;
import aofa.permutation.Permutation;
import aofa.permutation.generator.PermutationGenerator;
import aofa.permutation.implementation.ArrayPermutation;
import aofa.permutation.pattern.SetOfCyclesPatternAnalyzer;
import aofa.permutation.pattern.YoungTableauxAnalyzer;

public class Test {
    public static void main(String [] args){
        int size=1000;
        InputSource<ArrayPermutation> is=new PermutationGenerator(10,size);
        AnalysisCollector<Permutation> ac=new AnalysisCollector<>();
        ac.addAnalyzer(new SetOfCyclesPatternAnalyzer());
        ac.addAnalyzer(new YoungTableauxAnalyzer());
        do{
            Permutation p = is.next();
            ac.launchAndCollectAnalysis(p);
            //System.out.println(p);
            System.out.println(ac.lastAnalysis());
        }while (is.hasNext());
    }
}
