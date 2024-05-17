/**
 * This class creates a Doubly LinkedList, an abstract data type used to "chain"
 * instances together.
 * 
 * @author Alec Ferguson
 * @version 3.14.2024
 */
public class LinkedList {
    /**
     * The node class creates an instance of data.
     * 
     * @author Alec Ferguson
     * @version 3.14.2024
     */
    private class Node {
        public Field value;
        public Node prev;
        public Node next;

        /**
         * Default Constructor for a Node
         * 
         * @param value Field Value
         */
        public Node(Field value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    // Creates a 'head' and 'tail' node used to keep track of the front and end of
    // the list
    private Node head;
    private Node tail;

    /**
     * Default Constructor for the LinkedList
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Prints information about the author of this class
     * 
     * @return String
     */
    public String about() {
        return "Alec Ferguson";
    }

    /**
     * Adds to the 'head' or 'front' of the list
     * 
     * @param value Field value
     */
    public void addHead(Field value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    /**
     * Adds to the 'tail' or the 'end' of the list //Revised for Radix Sort
     * 
     * @param value Field value
     */
    public void addTail(Field value) {
        Node node = new Node(value);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
        }
    }

    /**
     * Removes from the head of the list. //Revised for Radix Sort
     * 
     * @return result
     */
    public Field removeHead() {
        Field result;
        if (this.head == null) { // If list is empty
            return null;
        } else if (this.head == this.tail) { // Used in the case the list has one remaining element
            result = head.value;
            this.head = null;
            this.tail = null;
            return result;
        } else { // Final case is used to move forward the head and set prev pointer to null
            result = head.value;
            head = head.next;
            head.prev = null;
        }
        return result;
    }

    /**
     * Removes from the end of the list.
     * 
     * @return result
     */
    public Field removeTail() {
        Field result;
        if (isEmpty()) { // If the list is empty
            return result = null;
        } else if (head == tail) { // Used in the case the list has one remaining element
            result = tail.value;
            head = null;
            tail = null;
        } else { // Final case used to step back in the list then set the next pointer to null
            result = tail.value;
            tail = tail.prev;
            tail.next = null;
        }
        return result;
    }

    /**
     * Checks if head or front of the list is empty.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Revised toString
     * 
     * @return list
     */
    public String toString() {
        StringBuilder list = new StringBuilder(); // Using a Revised String Builder
        Node cur = head;
        while (cur != null) {
            list.append(cur.value.key);
            list.append("\n");
            list.append(cur.value.value);
            if (cur.next != null) { // Prevents overstepping and adding another comma
                list.append("\n");
            }
            cur = cur.next;
        }
        return list.toString();
    }

    /**
     * Reverses the Revised toString
     * 
     * @return list
     */
    public String toStringReverse() {
        StringBuilder list = new StringBuilder(); // Using a Revised String Builder
        Node cur = tail;
        while (cur != null) {
            list.append(cur.value.value);
            if (cur.prev != null) { // Prevents overstepping and adding another comma
                list.append(", ");
            }
            cur = cur.prev;
        }
        return list.toString();
    }
}