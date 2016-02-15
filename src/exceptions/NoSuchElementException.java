
package exceptions;

/**
 * To be thrown if no element is found in a Container
 * @author James
 * @version 1.0
 */
public class NoSuchElementException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchElementException</code> without
     * detail message.
     */
    public NoSuchElementException() {
    }

    /**
     * Constructs an instance of <code>NoSuchElementException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchElementException(String msg) {
        super(msg);
    }
}
