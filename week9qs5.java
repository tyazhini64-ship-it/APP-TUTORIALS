import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class week9qs5 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/college";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "Dlarame+16";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            while (true) {
                System.out.println("\nStore Inventory System");
                System.out.println("1. Insert New Product");
                System.out.println("2. Retrieve Product by ID");
                System.out.println("3. Update Product Quantity");
                System.out.println("4. Display Products with Quantity Below 10");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter Product ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    String query = "INSERT INTO Product VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, id);
                    pstmt.setString(2, name);
                    pstmt.setDouble(3, price);
                    pstmt.setInt(4, quantity);
                    pstmt.executeUpdate();
                    System.out.println("Product inserted successfully.");
                } else if (choice == 2) {
                    System.out.print("Enter Product ID to search: ");
                    String id = sc.nextLine();

                    String query = "SELECT * FROM Product WHERE ProductID = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, id);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        System.out.println("Product ID: " + rs.getString("ProductID") + 
                                           ", Name: " + rs.getString("ProductName") + 
                                           ", Price: " + rs.getDouble("Price") + 
                                           ", Quantity: " + rs.getInt("Quantity"));
                    } else {
                        System.out.println("Product not found.");
                    }
                } else if (choice == 3) {
                    System.out.print("Enter Product ID to update quantity: ");
                    String id = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    String query = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, quantity);
                    pstmt.setString(2, id);
                    int rows = pstmt.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Quantity updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                } else if (choice == 4) {
                    String query = "SELECT * FROM Product WHERE Quantity < 10";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    boolean found = false;
                    while (rs.next()) {
                        found = true;
                        System.out.println("Product ID: " + rs.getString("ProductID") + 
                                           ", Name: " + rs.getString("ProductName") + 
                                           ", Price: " + rs.getDouble("Price") + 
                                           ", Quantity: " + rs.getInt("Quantity"));
                    }
                    if (!found) {
                        System.out.println("No products found with quantity below 10.");
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