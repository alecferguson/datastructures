
/**
 * The Main class tests the BinarySearch Tree
 * @author Alec Ferguson
 * @version 04.10.2024
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String test = "halloween calories 2.txt"; // Enter test file here
        BinarySearchTree tree = new BinarySearchTree(); // Creating main tree
        // Beginning File input logic
        try {
            Scanner input = new Scanner(new File(test));
            String key = "";
            String value = "";
            while (input.hasNextLine()) {
                key = input.nextLine();
                value = input.nextLine();
                if (key.equals("0")) {
                    break;
                }
                tree.add(Integer.parseInt(key), value); // Adding values to tree
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        // End File input logic.

        // Testing
        System.out.println("Generating Tree...\n" + tree.toTree());
        System.out.println("Generating SortedList...\n" + tree.toSortedList());
        System.out.println("Finding 77: " + tree.find(77));
        System.out.println("Attempting to find non-existing key: " + tree.find(33));
    }
}