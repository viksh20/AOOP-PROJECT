import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationSystem {
    private final Database database;

    public ReservationSystem(Database database) {
        this.database = database;
    }

    public void bookTable(String customerName, int tableId, String reservationTime) throws SQLException {
        database.connect();
        String query = "INSERT INTO reservations (customer_name, table_id, reservation_time) VALUES (?, ?, ?)";
        database.executeQuery(query, customerName, tableId, reservationTime);
        database.disconnect();
    }

    public void manageReservation(int reservationId, String newTime) throws SQLException {
        database.connect();
        String query = "UPDATE reservations SET reservation_time = ? WHERE reservation_id = ?";
        database.executeQuery(query, newTime, reservationId);
        database.disconnect();
    }

    public void notifyCustomer(int customerId, String message) throws SQLException {
        database.connect();
        String query = "SELECT email FROM customers WHERE customer_id = ?";
        database.executeQuery(query, customerId);
        ResultSet results = database.fetchResults();
        String email = null;
        if (results.next()) {
            email = results.getString("email");
        }
        database.disconnect();

        if (email != null) {
            // Send email logic
            System.out.println("Sending email to " + email + ": " + message);
        } else {
            System.out.println("Customer email not found.");
        }
    }
}
