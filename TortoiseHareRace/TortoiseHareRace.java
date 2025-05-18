class TortoiseHareRace {
    public static void main(String[] args) {
        // Total race distance
        final int raceDistance = 100;

        // Thread for Tortoise
        Thread tortoise = new Thread(() -> {
            for (int i = 1; i <= raceDistance; i++) {
                System.out.println("Tortoise has covered: " + i + " meters");
                try {
                    Thread.sleep(100); // Tortoise moves slowly
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Tortoise wins the race!");
            System.exit(0); // End the race
        });

        // Thread for Hare
        Thread hare = new Thread(() -> {
            for (int i = 1; i <= raceDistance; i++) {
                System.out.println("Hare has covered: " + i + " meters");
                try {
                    if (i == raceDistance / 2) {
                        System.out.println("Hare is taking a nap...");
                        Thread.sleep(2000); // Hare sleeps
                    }
                    Thread.sleep(50); // Hare moves faster
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hare finishes the race but loses!");
            System.exit(0); // End the race
        });

        // Start the race
        System.out.println("The race begins!");
        tortoise.start();
        hare.start();
    }
}