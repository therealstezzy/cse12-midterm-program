/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/
//other import statements

import static org.junit.Assert.assertTrue;
import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {
    private MyArrayList myAL;

    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        Object[] myArray = {10,2,3,4,20,6,7,8};
        myAL = new MyArrayList<>(myArray);
    }
    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        boolean exceptionThrown = false;
        try{
            myAL.reverseRegion(-1, 2);
        }catch(IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Exception was not thrown!", exceptionThrown);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        myAL.reverseRegion(7, 2);

        Object[] myArray = {10,2,3,4,20,6,7,8};

        boolean equal = false;
        for(int i = 0; i < myAL.size; i++){
            if(myAL.data[i] != myArray[i]){
                equal = false;
                break;
            }else{
                equal = true;
            }
        }
        assertTrue("Array does not reverse at specificed index range", equal);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        Object[] myArray = {10,2,6,20,4,3,7,8};
        myAL.reverseRegion(2,5);   // We are reversing from index 4 to index 5

        boolean equal = false;
        for(int i = 0; i < myAL.size; i++){
            if(myAL.data[i] != myArray[i]){
                equal = false;
                break;
            }else{
                equal = true;
            }
        }
        assertTrue("Array does not reverse at specificed index range", equal);
    }
    
    /**
     * Custom test
     * This test will see if the list is completely reversed from index 0
     * to index 7
    */
    @Test
    public void testReverseCustom(){
        Object[] myArray = {8,7,6,20,4,3,2,10};
        myAL.reverseRegion(0,7); 
             
        boolean equal = false;
        for(int i = 0; i < myAL.size; i++){
            if(myAL.data[i] != myArray[i]){
                equal = false;
                break;
            }else{
                equal = true;
            }
        }
        assertTrue("My array list does not reverse at specificed index range", equal);
    }
}