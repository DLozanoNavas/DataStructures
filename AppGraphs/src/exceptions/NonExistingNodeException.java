package exceptions;

/**
 *
 * @author Patricia
 */

public class NonExistingNodeException extends Exception{
    public NonExistingNodeException(String message){
        super(message);
    }
}
