import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class ReservationSystemTest {

    @Mock
    private DatabaseDriver mockDriver;

    @Mock
    private ResultSet mockResultSet;

    private Database mockDatabase;
    private ReservationSystem reservationSystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockDatabase = new Database(mockDriver);
        reservationSystem = new ReservationSystem(mockDatabase);
    }

    @Test
    public void testBookTable() throws SQLException {
        reservationSystem.bookTable("John Doe", 1, "2024-08-20 19:00:00");
        verify(mockDriver).executeQuery(
            "INSERT INTO reservations (customer_name, table_id, reservation_time) VALUES (?, ?, ?)",
            "John Doe", 1, "2024-08-20 19:00:00"
        );
    }

    @Test
    public void testManageReservation() throws SQLException {
        reservationSystem.manageReservation(1, "2024-08-20 20:00:00");
        verify(mockDriver).executeQuery(
            "UPDATE reservations SET reservation_time = ? WHERE reservation_id = ?",
            "2024-08-20 20:00:00", 1
        );
    }

    @Test
    public void testNotifyCustomer() throws SQLException {
        when(mockDriver.fetchResults()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("email")).thenReturn("john.doe@example.com");

        reservationSystem.notifyCustomer(1, "Your reservation is confirmed.");

        verify(mockDriver).executeQuery(
            "SELECT email FROM customers WHERE customer_id = ?", 1
        );
        // Verify that the email sending logic is correct
        // You can use a mock for the email service if needed
    }
}
