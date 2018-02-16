package aofa.algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgorithmSet<T> {
    private HashMap<String,T> algorithms=new HashMap<>();
    private ArrayList<String> algorithmsNames=new ArrayList<>();

    public int size(){
        return getAlgorithmsNames().size();
    }

    public void add(String pName,T pAlgorithm){
        algorithmsNames.add(pName);
        algorithms.put(pName,pAlgorithm);
    }

    public ArrayList<String> getAlgorithmsNames() {
        return algorithmsNames;
    }

    public T getAlgorithm(String pName){
        return algorithms.get(pName);
    }
}
