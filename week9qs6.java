import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class week9qs6 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/college";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "Dlarame+16";

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.print("Enter the Course Code to view registered students: ");
            String inputCourseCode = inputScanner.nextLine();

            String query = "SELECT * FROM CourseRegistration WHERE CourseCode = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, inputCourseCode);
            ResultSet resultSet = statement.executeQuery();

            boolean studentFound = false;
            System.out.println("\n--- Student Registration Details ---");
            while (resultSet.next()) {
                studentFound = true;
                System.out.println("Student ID: " + resultSet.getString("StudentID") + 
                                   " | Name: " + resultSet.getString("StudentName") + 
                                   " | Course Code: " + resultSet.getString("CourseCode") + 
                                   " | Course Name: " + resultSet.getString("CourseName") + 
                                   " | Semester: " + resultSet.getString("Semester"));
            }

            if (!studentFound) {
                System.out.println("No students are currently registered for the course code: " + inputCourseCode);
            }
        } catch (SQLException databaseError) {
            databaseError.printStackTrace();
        }
    }
}