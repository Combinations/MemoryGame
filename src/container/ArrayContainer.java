
package container;

import exceptions.EmptyContainerException;
import exceptions.NoSuchElementException;
import java.util.Random;

/**
 * ArrayContainer.java
 * This program implements ContainerADT
 * @author James
 * @version 1.0
 */
public class ArrayContainer<T> implements ContainerADT<T> {
    /**
     * Generic array to store objects. 
     */
    private T[] array;
    /**
     * counter variable that points to the next open spot in the container
     */
    private int top = 0;
    /**
     * Random Object to generate a random number
     */
    Random random = new Random();
    /**
     * Constructor - creates a container with 100 spaces
     * 
     */
    public ArrayContainer() {
        array = (T[]) new Object[100];
    }
    /**
     * Constructor - creates a container with the size specified by the user
     * @param elements  chosen by the user create a container of size elements 
     */
    public ArrayContainer(int elements) {
        array = (T[]) new Object[elements];
    }
    /**
     * Adds a new element to the container, checks first to see if the container
     * is full - if it is full creates a new container with double the size
     * else adds the actual parameter to the container
     *
     * @param element object to be added to the container
     */
    @Override
    public void add(T element) {
        if (size() == maxSize()) {
            T[] temparray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temparray[i] = array[i];
            }
            array = temparray;
            array[top] = element;
            top++;
        } else {
            array[top] = element;
            top++;
        }
    }
    /**
     * Removes a random value from the container chosen by generating a random 
     * index between 0 and top
     * @return the object specified at the random index
     * @throws EmptyContainerException if there are no elements in the container
     */
    @Override
    public T removeRandom() throws EmptyContainerException {

        int randomValue = random.nextInt(top);
        T returnValue = array[randomValue];
        if (isEmpty()) {
            throw new EmptyContainerException();
        } else {
            array[randomValue] = array[top - 1];
            array[top - 1] = null;
            top--;
        }
        return returnValue;
    }
    /**
     * Removes an element specified by the user if it is in the container
     * @param element object chosen to be removed from the container
     * @return returns the object removed
     * @throws EmptyContainerException if the container is empty
     * @throws NoSuchElementException  if no element is in the container
     */
    @Override
    public T remove(T element) throws EmptyContainerException,
            NoSuchElementException {

        if (isEmpty()) {
            throw new EmptyContainerException();
        } 
            for (int i = 0; i < top; i++) {
                if (array[i] == element) {
                    T returnValue = array[i];
                    array[i] = array[top-1];
                    array[top-1] = null;
                    top--;
                    return returnValue;
                }
            }
            throw new NoSuchElementException();
        
    }
    /**
     * sets all values in the container to null.
     */
    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }
    /**
     * returns true if the container contains the element sent by parameter
     * @param target value to be checked
     * @return 
     */
    @Override
    public boolean contains(T target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
    /**
     * checks to see if the container is empty. 
     * @return true if container is empty else returns false
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }
    /**
     * Returns the size of the container
     * @return the number spaces in the container
     */
    @Override
    public int maxSize() {
        return array.length;
    }
    /**
     * Finds the number of elements in the container
     * @return the number of elements added to the container
     */
    @Override
    public int size() {
       return top;
    }
    /**
     * Returns a string representation of the container
     * @return string 
     */
    public String toString() {
        String returnString = "";
        for (int i = 0; i < top; i++) {
            returnString = returnString + array[i] + " ";
        }
        return returnString;
    }
}
