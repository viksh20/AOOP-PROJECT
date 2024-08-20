public class Database {
    private final DatabaseDriver driver;

    public Database(DatabaseDriver driver) {
        this.driver = driver;
    }

    public void connect() throws SQLException {
        driver.connect();
    }

    public void disconnect() throws SQLException {
        driver.disconnect();
    }

    public void executeQuery(String query, Object... params) throws SQLException {
        driver.executeQuery(query, params);
    }

    public ResultSet fetchResults() throws SQLException {
        return driver.fetchResults();
    }
}
