package aofa;

import aofa.algorithm.AlgorithmSet;
import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleSupplier;

public class AnalysisCollector<T> {
    private HashMap<T,HashMap<String,Double>> collection=new HashMap<>();
    private ArrayList<Analyzer<T>> analyzers=new ArrayList<>();
    private T last;

    public void addAnalyzer(Analyzer<T> a){
        a.listMethodLists();
        analyzers.add(a);
    }

    public void launchAndCollectAnalysis(T t){
        AlgorithmSet<DoubleSupplier> as;
        collection.put(t, new HashMap<>());
        for (Analyzer<T> a:analyzers) {
            a.initialize(t);
            as=a.getMethodList();
            for(String name:as.getAlgorithmsNames())
                collection.get(t).put(name, as.getAlgorithm(name).getAsDouble());
        }
        last=t;
    }

    public String lastAnalysis() {
        StringBuilder sb = new StringBuilder();
        if (last != null) {
            for (Map.Entry<String,Double> couple : collection.get(last).entrySet()) {
                sb.append(couple.getKey());
                sb.append(" : ");
                sb.append(couple.getValue());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
