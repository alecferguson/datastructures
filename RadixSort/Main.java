
/**
 * This class's purpose is to test the LinkedList/Queue ADT by Radix Sort
 * @author Alec Ferguson
 * @version 3.14.2024
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String fileName = "years.txt"; // Insert fileName here
    public static final int minKey = 0;
    public static final int maxKey = 10;

    public static void main(String[] args) {
        // Creating mainQueue this will be used like a list
        Queue mainQueue = new Queue();
        Queue[] bucket = new Queue[maxKey];
        // Creating "Buckets"
        for (int i = minKey; i < maxKey; i++) {
            bucket[i] = new Queue();
        }
        try {
            Scanner input = new Scanner(new File(fileName));
            int limit = Integer.parseInt(input.nextLine());
            System.out.println("This is the limit = " + limit); // Debugging
            String key = "";
            String value = "";
            // Reading from file and adding to mainQueue
            while (input.hasNextLine()) {
                key = input.nextLine();
                value = input.nextLine();
                if (key.equals("0")) { // Kind of sloppy may remove
                    break;
                }
                mainQueue.enqueue(new Field(key, value)); // Binder will combine key/value into a field
            }
            input.close();
            // Showing user unsorted queue
            System.out.println("Printing Unsorted Queue:\n" + mainQueue);
            // Starting Radix Sort
            for (int i = limit - 1; i >= 0; i--) {
                while (!mainQueue.isEmpty()) {
                    Field n = mainQueue.dequeue(); // We cannot directly ask for key without a dequeue
                    // Looking to store in the correct bucket[j]
                    for (int j = minKey; j < maxKey; j++) {
                        if (j == Integer.parseInt(n.key.substring(i, i + 1))) {
                            bucket[j].enqueue(n); // Bucket found! Enqueue n
                        }
                    }
                }
                // Dumping buckets back into mainQueue
                for (int y = minKey; y < maxKey; y++) {
                    while (!bucket[y].isEmpty()) {
                        mainQueue.enqueue(bucket[y].dequeue());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("\n\nPrinting Sorted Queue:\n" + mainQueue);
    }
}