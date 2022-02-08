/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */

/**
 * TODO: Add class header
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
	 * TODO: Method header comment here
	 */
    public void reverseRegion(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
        if(fromIndex < 0 || fromIndex > this.size || toIndex < 0 || toIndex > size){
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
