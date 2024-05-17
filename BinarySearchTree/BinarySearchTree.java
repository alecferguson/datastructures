/**
 * The Binary Search Tree utilizes the node class to create a tree.
 * @author Alec Ferguson
 * @version 04.09.2024
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public String about() {
        return "Alec Ferguson";
    }

    public String toTree() {
        return root.toTree("Root", 0);
    }

    public String toSortedList() {
        return root.toSortedList();
    }

    public void add(int key, String value) {
        if(root == null) { //Exception for when root is null
            root = new Node(key, value);
        } else {
            root.add(key, value);
        }
    }

    public String find(int key) {
        if(root == null) { //Exception for when root is null
            return "";
        } else {
            return root.find(key);
        }
    }
}