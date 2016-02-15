
package exceptions;

/**
 * Exception to be thrown if container is empty
 * @author James
 * @version 1.0
 */
public class EmptyContainerException extends Exception {

    /**
     * Creates a new instance of <code>EmptyContainerExcepetion</code> without
     * detail message.
     */
    public EmptyContainerException() {
    }

    /**
     * Constructs an instance of <code>EmptyContainerExcepetion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyContainerException(String msg) {
        super(msg);
    }
}
