/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
        Object[] myArray = {1,2,3,4,5,6,7,8};
        myAL = new MyArrayList<>(myArray);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        //TODO: Add your test case
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
        //TODO: Add your test case

        // MyArrayList Tester
        myAL.reverseRegion(7, 2);

        Object[] myArray = {1,2,3,4,5,6,7,8};

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

        //TODO: Add your test case

        // MyArrayList tester
        Object[] myArray = {1,2,3,4,6,5,7,8};
    
        myAL.reverseRegion(4,5);   // We are reversing from index 4 to index 5

        for(Object x : myAL.data){
            System.out.print(x);
        }

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
    */
    @Test
    public void testReverseCustom(){
        //TODO: Add your test case

        // MyArrayList Tester
        Object[] myArray = {8,7,6,5,4,3,2,1};
        myAL.reverseRegion(0,7); 
        
            for(Object x : myAL.data){
            System.out.print(x);
        }
        
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
}
