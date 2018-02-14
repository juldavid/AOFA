package aofa;

public interface Evaluator<Input,Algorithm,Measures> {
    void associateInputsToValue();

    Measures getMeasures(InputSource<Input> i,Algorithm a);
}
