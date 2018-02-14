package aofa.permutation.pattern;

import aofa.permutation.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SetOfCyclesPatternAnalyzer {
    private ArrayList<ArrayList<Integer>> setOfCycles=new ArrayList<>();

    public int numberOfCycles(){
        return setOfCycles.size();
    }

    /*public int longuestCycle(){
        return setOfCycles.stream().max(cycle -> cycle.size()).size();
    }

    public Optional<Integer> smallestCycle(){
        return setOfCycles.stream().map(cycle -> cycle.size()).min();
    }*/

    public long fixedPoints(){
        return setOfCycles.stream().filter(cycle -> cycle.size()==1).count();
    }


    public void computeSetOfCycles(Permutation p){
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

}
