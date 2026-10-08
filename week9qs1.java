import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class StudentModel {
    private String name;
    private double m1,m2,m3;
    private double total,average;
    private char grade;

    public void setStudentData(String name, double m1, double m2, double m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        computeGrade();
    }

    private void computeGrade() {
        total = m1 + m2 + m3;
        average = total / 3.0;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    public char getGrade() {
        return grade;
    }
}

class StudentView extends JFrame {
    private JTextField nameInput = new JTextField(15);
    private JTextField sub1Input = new JTextField(5);
    private JTextField sub2Input = new JTextField(5);
    private JTextField sub3Input = new JTextField(5);
    private JButton calculateBtn = new JButton("Calculate Result");
    private JLabel outputLabel = new JLabel("Enter details and click calculate.");

    public StudentView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 2, 5, 5));
        add(new JLabel("Student Name:"));
        add(nameInput);
        add(new JLabel("Mark 1:"));
        add(sub1Input);
        add(new JLabel("Mark 2:"));
        add(sub2Input);
        add(new JLabel("Mark 3:"));
        add(sub3Input);
        add(calculateBtn);
        add(outputLabel);
    }

    public String getStudentName() {
        return nameInput.getText();
    }

    public double getMarkOne() {
        return Double.parseDouble(sub1Input.getText());
    }

    public double getMarkTwo() {
        return Double.parseDouble(sub2Input.getText());
    }

    public double getMarkThree() {
        return Double.parseDouble(sub3Input.getText());
    }

    public void setOutputText(String text) {
        outputLabel.setText(text);
    }

    public void attachCalculateEvent(ActionListener listener) {
        calculateBtn.addActionListener(listener);
    }
}

class StudentController {
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController(StudentModel studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
        this.studentView.attachCalculateEvent(e -> processGrades());
    }

    private void processGrades() {
        try {
            String studentName = studentView.getStudentName();
            double mark1 = studentView.getMarkOne();
            double mark2 = studentView.getMarkTwo();
            double mark3 = studentView.getMarkThree();
            
            studentModel.setStudentData(studentName, mark1, mark2, mark3);
            
            String outcome = String.format("<html>Total: %.2f<br>Average: %.2f<br>Grade: %c</html>",
                    studentModel.getTotal(), studentModel.getAverage(), studentModel.getGrade());
            studentView.setOutputText(outcome);
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(studentView, "Please check your inputs and enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public class week9qs1 {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        new StudentController(model, view);
        view.setVisible(true);
    }
}