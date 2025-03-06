import java.util.HashSet;
import java.util.Set;

public class SetInterfaceExample {
    public static void main(String[] args) {
        // Create a HashSet
        Set<String> fruits = new HashSet<>();

        // Add elements to the set
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate, will not be added

        // Display the set
        System.out.println("Fruits in the Set:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Remove an element
        fruits.remove("Banana");
        System.out.println("\nAfter removing 'Banana':");
        System.out.println(fruits);

        // Check if a set contains an element
        System.out.println("\nDoes the set contain 'Apple'? " + fruits.contains("Apple"));
    }
}
