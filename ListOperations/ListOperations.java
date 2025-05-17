import java.util.ArrayList;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        // Create a list to store String objects
        ArrayList<String> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu options
            System.out.println("\n--- List Operations Menu ---");
            System.out.println("1. Insert Item");
            System.out.println("2. Delete Item");
            System.out.println("3. Display Items");
            System.out.println("4. Search Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Insert item
                    System.out.print("Enter item to insert: ");
                    String item = scanner.nextLine();
                    itemList.add(item);
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    // Delete item
                    System.out.print("Enter item to delete: ");
                    String deleteItem = scanner.nextLine();
                    if (itemList.remove(deleteItem)) {
                        System.out.println("Item deleted successfully!");
                    } else {
                        System.out.println("Item not found in the list!");
                    }
                    break;

                case 3:
                    // Display items
                    System.out.println("\nItems in the list:");
                    if (itemList.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        for (String listItem : itemList) {
                            System.out.println("- " + listItem);
                        }
                    }
                    break;

                case 4:
                    // Search item
                    System.out.print("Enter item to search: ");
                    String searchItem = scanner.nextLine();
                    if (itemList.contains(searchItem)) {
                        System.out.println("Item found in the list.");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}