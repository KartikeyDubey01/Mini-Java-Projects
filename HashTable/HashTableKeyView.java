import java.util.Hashtable;
import java.util.Set;

public class HashTableKeyView {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(101, "John");
        hashtable.put(102, "Jane");
        hashtable.put(103, "Alice");

        // Retrieve keys using keySet()
        Set<Integer> keys = hashtable.keySet();

        // Display keys
        System.out.println("Keys in the HashTable:");
        for (Integer key : keys) {
            System.out.println(key);
        }
    }
}
