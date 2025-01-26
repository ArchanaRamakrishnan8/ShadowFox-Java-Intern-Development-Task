import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    public static void addBook(String title, String author) {
        String sql = "INSERT INTO books(title, author) VALUES(?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchBooks(String keyword) {
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Author: " + rs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
