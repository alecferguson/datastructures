/**
 * This class creates a Doubly LinkedList, an abstract data type used to "chain" instances together.
 * @author Alec Ferguson
 * @version 2.9.2024
 */
public class LinkedList {
    /**
     * The node class creates an instance of data.
     * @author Alec Ferguson
     * @version 2.9.2024
     */
    private class Node {
        public String data; //Can we use this instead?
        public Node prev;
        public Node next;
        /**
         * Default Constructor for a Node
         * @param data
         */
        public Node(String data) { //Can we use data?
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    //Creates a 'head' and 'tail' node used to keep track of the front and end of the list
    public Node head;
    public Node tail;

    /**
     * Default Constructor for the LinkedList
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Prints information about the author of this class
     * @return String
     */
    public String about() {
        return "Alec Ferguson";
    }

    /**
     * Adds to the 'head' or 'front' of the list
     * @param value
     */
    public void addHead(String value) {
        Node node = new Node(value);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    /**
     * Adds to the 'tail' or the 'end' of the list
     * @param value
     */
    public void addTail(String value) {
        Node node = new Node(value);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    /**
     * Removes from the head of the list.
     * @return result
     */
    public String removeHead() {
        String result;
        if (isEmpty()) { //If list is empty
            return "";
        }
        else if(head == tail) { //Used in the case the list has one remaining element
            result = head.data;
            head = null;
            tail = null;
            return result;
        } else { //Final case is used to move forward the head and set prev pointer to null
            result = head.data;
            head = head.next;
            head.prev = null;
        }
        return result;
    }

    /**
     * Removes from the end of the list.
     * @return result
     */
    public String removeTail() {
        String result;
        if(isEmpty()) { //If the list is empty
            return "";
        }
        else if(head == tail) { //Used in the case the list has one remaining element
            result = tail.data;
            head = null;
            tail = null;
        } else { //Final case used to step back in the list then set the next pointer to null
            result = tail.data;
            tail = tail.prev;
            tail.next = null;
        }
        return result;
    }

    /**
     * Checks if head or front of the list is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * toString
     * @return list
     */
    public String toString() {
        String list = ""; //Using String concatenation to return
        Node cur = head;
        while(cur != null) {
            list += cur.data;
            if(cur.next != null) { //Prevents overstepping and adding another comma
                list +=", ";
            }
            cur = cur.next;
        }
        return list;
    }

    /**
     * Reverses the toString
     * @return list
     */
    public String toStringReverse() {
        String list = ""; //Using String concatenation to return
        Node cur = tail;
        while(cur != null) {
            list += cur.data;
            if(cur.prev != null) { //Prevents overstepping and adding another comma
                list +=", ";
            }
            cur = cur.prev;
        }
        return list;
    }
}