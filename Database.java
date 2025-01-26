import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:library.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    public static void initialize() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                                  "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                  "username TEXT NOT NULL UNIQUE, " +
                                  "password TEXT NOT NULL)";
        String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                                  "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                  "title TEXT NOT NULL, " +
                                  "author TEXT NOT NULL)";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createBooksTable);
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            System.out.println("Database initialization error: " + e.getMessage());
        }
    }
}
