import java.util.Scanner;

public class VideoRentalStore {

    private static final int MAX_VIDEOS = 100;

    private static String[] videoTitles = new String[MAX_VIDEOS];
    private static boolean[] rentalStatus = new boolean[MAX_VIDEOS];
    private static int videoCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Video Rental Store Inventory ===");
            System.out.println("1. Add New Video");
            System.out.println("2. Mark Video as Rented");
            System.out.println("3. Mark Video as Returned");
            System.out.println("4. Remove Video");
            System.out.println("5. Display Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addVideo(sc);
                    break;
                case 2:
                    markRented(sc);
                    break;
                case 3:
                    markReturned(sc);
                    break;
                case 4:
                    removeVideo(sc);
                    break;
                case 5:
                    displayInventory();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addVideo(Scanner sc) {
        if (videoCount >= MAX_VIDEOS) {
            System.out.println("Inventory full! Cannot add more videos.");
            return;
        }
        System.out.print("Enter video title: ");
        String title = sc.nextLine();
        videoTitles[videoCount] = title;
        rentalStatus[videoCount] = false; // Default to available
        videoCount++;
        System.out.println("Video added successfully!");
    }

    private static void markRented(Scanner sc) {
        System.out.print("Enter video title to mark as rented: ");
        String title = sc.nextLine();
        int index = findVideo(title);
        if (index == -1) {
            System.out.println("Video not found!");
        } else if (rentalStatus[index]) {
            System.out.println("Video is already rented!");
        } else {
            rentalStatus[index] = true;
            System.out.println("Video marked as rented.");
        }
    }

    private static void markReturned(Scanner sc) {
        System.out.print("Enter video title to mark as returned: ");
        String title = sc.nextLine();
        int index = findVideo(title);
        if (index == -1) {
            System.out.println("Video not found!");
        } else if (!rentalStatus[index]) {
            System.out.println("Video is already available!");
        } else {
            rentalStatus[index] = false;
            System.out.println("Video marked as returned.");
        }
    }

    private static void removeVideo(Scanner sc) {
        System.out.print("Enter video title to remove: ");
        String title = sc.nextLine();
        int index = findVideo(title);
        if (index == -1) {
            System.out.println("Video not found!");
        } else {
            for (int i = index; i < videoCount - 1; i++) {
                videoTitles[i] = videoTitles[i + 1];
                rentalStatus[i] = rentalStatus[i + 1];
            }
            videoCount--;
            System.out.println("Video removed successfully!");
        }
    }

    private static void displayInventory() {
        if (videoCount == 0) {
            System.out.println("No videos in inventory.");
            return;
        }
        System.out.println("\nCurrent Inventory:");
        System.out.println("------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s\n", "No.", "Title", "Status");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < videoCount; i++) {
            String status = rentalStatus[i] ? "Rented" : "Available";
            System.out.printf("%-5d %-20s %-10s\n", (i + 1), videoTitles[i], status);
        }
    }

    private static int findVideo(String title) {
        for (int i = 0; i < videoCount; i++) {
            if (videoTitles[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }
}
