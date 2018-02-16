package aofa.permutation.pattern;

import aofa.Analyzer;
import aofa.permutation.Permutation;

import java.util.ArrayList;

/**
 * Builds YoungTableaux from a permutation using the Schensted Algorithm.
 * Using the tableaux, we can then extract useful information on the permutation, like
 * length of increasing and decreasing subsequences.
 */
public class YoungTableauxAnalyzer extends Analyzer<Permutation>{
    private static ArrayList<ArrayList<Integer> > youngTableauxP =new ArrayList<>();
    private static ArrayList<ArrayList<Integer> > youngTableauxQ =new ArrayList<>();

    private int rowInsertion(int rowI,int value,int pos){
        int i=0,tmp;
        ArrayList<Integer> rowP=youngTableauxP.get(rowI);
        while(i<rowP.size()){
            if(value<rowP.get(i)) {
                tmp = rowP.get(i);
                rowP.set(i,value);
                return tmp;
            }
            i++;
        }
        rowP.add(value);
        youngTableauxQ.get(rowI).add(pos);
        return -1;
    }

    private void insertion(int x,int pos){
        int i=0;
        while(i< youngTableauxP.size()&&x>=0){
            x=rowInsertion(i,x,pos);
            i++;
        }
        if(i== youngTableauxP.size()&&x!=-1){
            youngTableauxP.add(new ArrayList<>());
            youngTableauxP.get(i).add(x);
            youngTableauxQ.add(new ArrayList<>());
            youngTableauxQ.get(i).add(pos);
        }
    }

    /**
     * Builds YoungTableaux from the permutation p using the Schensted Algorithm.
     * @param p is the permutation we want to analyse.
     */
    private void SchenstedAlgorithm(Permutation p){
        for(int i=0;i<p.size();i++){
            insertion(p.getValue(i),i+1);
        }
    }

    private static double longuestIncreasingSubsequence(){
        return youngTableauxP.get(0).size();
    }
    private static double longuestDecreasingSubsequence(){
        return youngTableauxP.size();
    }

    @Override
    public void listMethodLists() {
        addMethod("Longuest Increasing Subsequence",YoungTableauxAnalyzer::longuestIncreasingSubsequence);
        addMethod("Longuest Decreasing Subsequence",YoungTableauxAnalyzer::longuestDecreasingSubsequence);
    }

    @Override
    public void initialize(Permutation permutation) {
        youngTableauxQ.clear();
        youngTableauxP.clear();
        SchenstedAlgorithm(permutation);
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(ArrayList<Integer> row:youngTableauxP){
            for(int x:row) {
                sb.append(x);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
