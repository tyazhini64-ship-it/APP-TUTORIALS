
import java.sql.*;
import java.util.Scanner;

public class week9qs4 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/college";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "Dlarame+16";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            while (true) {
                System.out.println("\nLibrary Management System");
                System.out.println("1. Insert New Book");
                System.out.println("2. Search Book by ID");
                System.out.println("3. Display Available Books");
                System.out.println("4. Change Availability Status");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Availability Status (Available/Issued): ");
                    String availability = sc.nextLine();

                    String query = "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, id);
                    pstmt.setString(2, title);
                    pstmt.setString(3, author);
                    pstmt.setDouble(4, price);
                    pstmt.setString(5, availability);
                    pstmt.executeUpdate();
                    System.out.println("Book inserted successfully.");
                } else if (choice == 2) {
                    System.out.print("Enter Book ID to search: ");
                    String id = sc.nextLine();

                    String query = "SELECT * FROM Book WHERE BookID = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, id);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        System.out.println("Book ID: " + rs.getString("BookID") + 
                                           ", Title: " + rs.getString("Title") + 
                                           ", Author: " + rs.getString("Author") + 
                                           ", Price: " + rs.getDouble("Price") + 
                                           ", Availability: " + rs.getString("Availability"));
                    } else {
                        System.out.println("Book not found.");
                    }
                } else if (choice == 3) {
                    String query = "SELECT * FROM Book WHERE Availability = 'Available'";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    boolean found = false;
                    while (rs.next()) {
                        found = true;
                        System.out.println("Book ID: " + rs.getString("BookID") + 
                                           ", Title: " + rs.getString("Title") + 
                                           ", Author: " + rs.getString("Author") + 
                                           ", Price: " + rs.getDouble("Price"));
                    }
                    if (!found) {
                        System.out.println("No available books found.");
                    }
                } else if (choice == 4) {
                    System.out.print("Enter Book ID to update availability: ");
                    String id = sc.nextLine();
                    System.out.print("Enter new status (Available/Issued): ");
                    String status = sc.nextLine();

                    String query = "UPDATE Book SET Availability = ? WHERE BookID = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, status);
                    pstmt.setString(2, id);
                    int rows = pstmt.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Availability status updated successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                } else if (choice == 5) {
                    System.out.println("Exiting program.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}