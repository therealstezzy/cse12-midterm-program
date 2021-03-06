/**
 * TODO: Add your file header
 * Name: Christopher Rebollar-Ramirez
 * ID: A16982224
 * Email: crebollarramirez@ucsd.edu
 * File description: This file contains the class MyLinkedList that contains classes
 * and methods used to form a linked list. This file is 207 lines long.
 */

/**
 * This class is used to create a linked list. Inside the class, there is another class called
 *  Node since a linked list is constructed with nodes. The MyLinkedList class implements 
 *  MyReverseList meaning that it should contain the methods size(), reverseRegion(), get().
 *  This class contains methods that alter the linked list and nodes. 
 */
public class MyLinkedList<E> implements MyReverseList<E>{

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes
     * This class is used for both MyLinkedList and MyListIterator.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            //Initialise the elements
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the previous node in the list
         * @param p new previous node
         */
        public void setPrev(Node p) {
            //Set the node p on the previous position
            prev = p;
        }

        /** 
         * Set the next node in the list
         * @param n new next node
         */
        public void setNext(Node n) {
            //Set the node n on the next position
            next = n;
        }

        /** 
         * Set the element 
         * @param e new element 
         */
        public void setElement(E e) {
            this.data = e;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!
    /**
     * Constructor to create a doubly linked list 
     * with the argument array's elements
     * @param arr - array of elements to be used to construct the LinkedList
     */
    public MyLinkedList(E[] arr) {

        //Create dummy nodes
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;	

        if(arr != null){
            //create list by inserting each element
            Node currNode = head;
            for(int i=0; i<arr.length; i++){
                Node newNode = new Node(arr[i]);
                currNode.next.prev = newNode;
                newNode.next = currNode.next;
                newNode.prev = currNode;
                currNode.next = newNode;

                //move pointer to the next node
                currNode = currNode.next;
                //increase size of list
                this.size++;
            }
        }
    }

    /**
     * This method will reverse the linked list from a certain index to a index.
     * This method will not reverse the nodes themselves, just the data,
     * which is the same thing as reversing the nodes.  
     */
    public void reverseRegion(int fromIndex, int toIndex){
        // This checks if fromIndex or toIndex is out of range of the linked list
        if(fromIndex < 0 || fromIndex > this.size-1 || toIndex < 0 || toIndex > size-1){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex < toIndex){
            Node current = head;

            int k = toIndex-fromIndex +1;   // The  size of smallArray that holds values from index specficed to index specified
            Object[] smallArray = new Object[k];
    
            for(int i = 0; i <= fromIndex; i++){
                current = current.getNext();
            }
            Node fromIndexNode = current; // Node that is at fromIndex
    
            // This will copy data from each node and insert it in the smallArray but from right to left
            // allowing the smallArray to be in reverse order already.
            for(int p = smallArray.length - 1; p != - 1; p--){
                smallArray[p] = current.data;
                current = current.getNext();
            }    
            // This loop will change the data of the nodes but in reverse order
            for(int i = 0; i < smallArray.length; i++){
                fromIndexNode.data = (E)smallArray[i];
                fromIndexNode = fromIndexNode.getNext();
            }
        }
    }

    @Override
    /** 
     * Returns the number of elements stored
     * @return - number of elements in the linkedlist
    */
    public int size() {
        //Return the number of nodes in the linkedlist
        return this.size;
    }

    @Override
    /** 
     * Get contents at position i
     * @param index - The index position to obtain the data
     * @return the Element at the specified index
     */
    public E get(int index)	{

        Node currNode = this.getNth(index);

        //Get the value of data at the position
        E element = currNode.getElement();

        return element;	
    }


    /** A method that returns the node at a specified index,
     *  not the content
     *  @param index - position to return the node
     * @return - Node at 'index'
     */
    // Helper method to get the Node at the Nth index
    protected Node getNth(int index) {
        if (index >= this.size || index < 0)
            throw new IndexOutOfBoundsException();

        Node currNode = this.head;

        //Loop through the linked list and stop at the position
        for (int i = 0; i <= index; i++) {
            currNode = currNode.getNext();
        }

        //return the node	
        return currNode; 
    }
}