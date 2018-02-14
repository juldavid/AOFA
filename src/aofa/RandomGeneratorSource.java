package aofa;

/**
 * RandomGeneratorSource implements the InputSource interface.
 * The number of generated objects is given at the construction.
 * @param <Input>  is the class of objects that will be randomly generated and given to the algorithms.
 */
public abstract class RandomGeneratorSource<Input> implements InputSource<Input>{
    private int number; //Number of objects to generate;
    private int generated; //Number of generated objects;

    public abstract Input random();

    /**
     * Checks if the number of generated objects is still lower than the number that was asked.
     * @return true the number of generated objects is still lower than the number that was asked, false otherwise.
     */
    public boolean hasNext(){
        return generated<number;
    }

    /**
     * Calls the random method and increment the number of generated objects.
     * @return a random Input
     * @throws RuntimeException if someone calls this method more than what if asked for at the construction.
     */
    public Input next() throws RuntimeException{
        if(generated>=number)
            throw new RuntimeException("Number of resquested objects exceeds initialization parameters");
        generated++;
        return random();
    }

    /**
     * Initialize the number of objects to generate.
     * @param pNumber is the number of objects to generate.
     */
    public RandomGeneratorSource(int pNumber){
        number=pNumber;
    }
}
