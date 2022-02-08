/**
 * TODO: Add your file header
 * Name: Christopher Rebollar-Ramirez
 * ID: A16982224
 * Email: crebollarramirez@ucsd.edu
 * File description: This file contains the class MyArrayList that implements MyReverseList.
 * This file is also tested by the ReverseArrayList tester due to the class contains a method
 * that needs to be tested. This file is 80 lines long. 
 */

/**
 * Class Header: This class is used for creating array lists.
 * The class contains member variables data and size. Data is an array
 * that stores elements which size corresponds to how many elements are
 * in the data array. This class is used to make the data array seem
 * like an array that doesn't need to expand capacitiy manually. This class is 
 * tested by the ReverseArrayListTester class.
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * This method reverses the arraylist at a specific index. This method will also throw 
     * an index out of bounds if fromIndex or toIndex is out of the bounds of the arraylist.
     * This method will not alter the arraylist if toIndex < fromIndex
	 */
    public void reverseRegion(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
        if(fromIndex < 0 || fromIndex > this.size-1 || toIndex < 0 || toIndex > this.size-1){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex < toIndex){
            for(int i = 0; i < (toIndex-fromIndex + 1)/2; i++){ // We are dividing by 2 because we are swapping 2 times at a time
                // Swapping items for reverse
                E tempData = (E)this.data[fromIndex + i];
                this.data[fromIndex+i] = this.data[(toIndex - i)];
                this.data[(toIndex-i)] = tempData;
            }
        }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}