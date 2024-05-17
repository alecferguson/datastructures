/**
 * This class's purpose is to store a key-value String
 * 
 * @author Alec Ferguson
 * @version 3.14.2024
 */
public class Field {
    public String key;
    public String value;

    public Field(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        String debug = "";
        debug += this.key;
        debug += ",";
        debug += this.value;
        return debug;
    }
}