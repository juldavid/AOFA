package aofa.permutation.pattern;

import aofa.Analyzer;
import aofa.permutation.Permutation;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SetOfCyclesPatternAnalyzer extends Analyzer<Permutation>{
    private static ArrayList<ArrayList<Integer>> setOfCycles=new ArrayList<>();

    private static double numberOfCycles(){
        return setOfCycles.size();
    }

    private static IntStream cyclesLength(){
        return setOfCycles.stream().mapToInt(ArrayList::size);
    }

    private static double averageCycleLength(){
        OptionalDouble res=cyclesLength().average();
        if(!res.isPresent())
            throw new RuntimeException("Initialization failed or wasn't called");
        return res.getAsDouble();
    }

    private static double standardDeviation(){
        double average=averageCycleLength();
        OptionalDouble squareAverage=setOfCycles.stream().mapToDouble(c-> c.size()*c.size()).average();
        if(!squareAverage.isPresent())
            throw new RuntimeException("Initialization failed or wasn't called");
        return squareAverage.getAsDouble()-(average*average);
    }

    private static double longuestCycle(){
        OptionalInt res=cyclesLength().max();
        if(!res.isPresent())
            throw new RuntimeException("Initialization failed or wasn't called");
        return res.getAsInt();
    }

    private static double smallestCycle(){
        OptionalInt res=cyclesLength().min();
        if(!res.isPresent())
            throw new RuntimeException("Initialization failed or wasn't called");
        return res.getAsInt();
    }

    private static double fixedPoints(){
        return (int)(setOfCycles.stream().filter(cycle -> cycle.size()==1).count());
    }

    private static void computeSetOfCycles(Permutation p){
        int i,tmp;
        boolean seen[]=new boolean[p.size()];
        Arrays.fill(seen, Boolean.FALSE);
        for(i=0;i<p.size();i++){
            if(!seen[i]){
                ArrayList<Integer> cycle=new ArrayList<>();
                tmp=i;
                while(!seen[tmp]){
                    cycle.add(tmp+1);
                    seen[tmp]=true;
                    tmp=p.getValue(tmp)-1;
                }
                setOfCycles.add(cycle);
            }
        }
    }

    @Override
    public void listMethodLists() {
        addMethod("Number of Cycles",SetOfCyclesPatternAnalyzer::numberOfCycles);
        addMethod("Average Cycle Length",SetOfCyclesPatternAnalyzer::averageCycleLength);
        addMethod("Standard Deviation of Cycle lenth",SetOfCyclesPatternAnalyzer::standardDeviation);
        addMethod("Longuest Cycle",SetOfCyclesPatternAnalyzer::longuestCycle);
        addMethod("Smallest Cycle",SetOfCyclesPatternAnalyzer::smallestCycle);
        addMethod("Number of Fixed Points",SetOfCyclesPatternAnalyzer::fixedPoints);
    }

    @Override
    public void initialize(Permutation permutation) {
        setOfCycles.clear();
        computeSetOfCycles(permutation);
    }
}
