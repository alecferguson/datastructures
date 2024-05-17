/**
 * This class represents a Queue ADT
 * 
 * @author Alec Ferguson
 * @version 3.14.2024
 */
public class Queue {
    private LinkedList list = new LinkedList();

    public void enqueue(Field item) {
        list.addTail(item);
    }

    public Field dequeue() {
        return list.removeHead();
    }

    public String toString() {
        return list.toString();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
