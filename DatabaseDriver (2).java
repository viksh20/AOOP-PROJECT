import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DatabaseDriver {
    void connect() throws SQLException;
    void disconnect() throws SQLException;
    void executeQuery(String query, Object... params) throws SQLException;
    ResultSet fetchResults() throws SQLException;
}

public class MySQLDriver implements DatabaseDriver {
    private Connection connection;

    @Override
    public void connect() throws SQLException {
        
    }

    @Override
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public void executeQuery(String query, Object... params) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
           
            stmt.execute(query);  
        }
    }

    @Override
    public ResultSet fetchResults() throws SQLException {
        
        return null;  
    }
}

public class PostgreSQLDriver implements DatabaseDriver {
    private Connection connection;

    @Override
    public void connect() throws SQLException {
      
    }

    @Override
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public void executeQuery(String query, Object... params) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            
            stmt.execute(query);  
        }
    }

    @Override
    public ResultSet fetchResults() throws SQLException {
        
        return null;  
    }
}
