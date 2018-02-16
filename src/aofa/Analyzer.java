package aofa;

import aofa.algorithm.AlgorithmSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.DoubleSupplier;

public abstract class Analyzer<T> {
    private AlgorithmSet<DoubleSupplier> methodList=new AlgorithmSet<>();

    public Analyzer() {
        listMethodLists();
    }


    public AlgorithmSet<DoubleSupplier> getMethodList() {
        return methodList;
    }

    protected void addMethod(String name,DoubleSupplier ds){
        methodList.add(name,ds);
    }

    public abstract void listMethodLists();

    public abstract void initialize(T t);

}
