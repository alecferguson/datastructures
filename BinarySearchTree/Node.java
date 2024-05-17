/**
 * This class creates a Node for a binary tree
 * @author Alec Ferguson
 * @version 04.09.2024
 */
public class Node {
    public int key;
    public String value;
    public Node left;
    public Node right;

    //Node Constructor
    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    //Uses StringBuilder to visualize the tree
    public String toTree(String label, int indent) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < indent * 3; i++) {
            result.append(" ");
        }
        result.append(label).append(": ");
        result.append("(").append(this.key).append(") ").append(this.value);
        result.append("\n");
        if(left != null) {
            result.append(left.toTree("L", indent + 1));
        }
        if(right != null) {
            result.append(right.toTree("R", indent + 1));
        }
        return result.toString();
    }

    //Uses StringBuilder to visualize the tree in a sorted list
    public String toSortedList() {
        StringBuilder result = new StringBuilder();
        if(left != null) {
            result.append(left.toSortedList());
        }
        result.append("(").append(this.key).append(") ").append(this.value);
        result.append(", ");
        if(right != null) {
            result.append(right.toSortedList());
        }
        return result.toString();
    }

    //Logic for adding a Node (uses recursion)
    public void add(int key, String value) {
        if(key < this.key) { 
            if(left == null) {
                left = new Node(key,value); //Base Case
            } else {
                left.add(key,value); //Recursion
            }
        }
        if(key > this.key) {
            if(right == null) {
                right = new Node(key,value);
            } else {
                right.add(key,value);
            }
        }
    }

    //Finds a value (uses recursion)
    public String find(int key) {
        if(key == this.key) { //Base Case
            return this.value;
        }
        if(left == null || right == null) { //Stop condition
            return "";
        }
        if(key < this.key) { //Case1
            return left.find(key);
        }
        if(key > this.key) { //Case2
            return right.find(key);
        }
        return "";
    }
}