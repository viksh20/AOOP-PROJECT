public class Main {

    public static void main(String[] args) {
        // Choose the database driver you want to use
        DatabaseDriver driver = new PostgreSQLDriver();

        // Create a Database instance with the chosen driver
        Database database = new Database(driver);

        // Create the ReservationSystem with the Database instance
        ReservationSystem reservationSystem = new ReservationSystem(database);

        try {
            // Connect to the database
            database.connect();

            // Perform some reservation operations
            System.out.println("Booking a table...");
            reservationSystem.bookTable("Alice Johnson", 1, "2024-08-20 19:00:00");

            System.out.println("Managing a reservation...");
            reservationSystem.manageReservation(1, "2024-08-20 21:00:00");

            System.out.println("Notifying a customer...");
            reservationSystem.notifyCustomer(1, "Your reservation has been updated.");

            // Disconnect from the database
            database.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
