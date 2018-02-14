package aofa;

import java.util.Iterator;

/**
 * InputSource is an interfaces that defines how to access the inputs that will be given to the algorithms,
 * indepentently from their sources (database, generator, file).
 * @param <Input> is the class of objects that will be extracted from the source and given to the algorithms.
 */
public interface InputSource<Input>{
    /**
     * This method returns if the source still contains inputs, false otherwise;
     * @return true if the source still contains inputs, false otherwise;
     */
    boolean hasNext();

    /**
     * Returns the next Input from the source.
     * @return the next Input from the source.
     */
    Input next();
}
