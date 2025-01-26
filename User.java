import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public static void register(String username, String password) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
