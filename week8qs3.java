import javax.swing.*;

public class week8qs3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration System");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 30, 100, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(140, 30, 180, 25);
        frame.add(txtName);

        JLabel lblReg = new JLabel("Register No:");
        lblReg.setBounds(30, 70, 100, 25);
        frame.add(lblReg);

        JTextField txtReg = new JTextField();
        txtReg.setBounds(140, 70, 180, 25);
        frame.add(txtReg);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 110, 100, 25);
        frame.add(lblGender);

        JRadioButton rbMale = new JRadioButton("Male");
        rbMale.setBounds(140, 110, 80, 25);
        JRadioButton rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(220, 110, 100, 25);
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbMale);
        bgGender.add(rbFemale);
        frame.add(rbMale);
        frame.add(rbFemale);

        JLabel lblDept = new JLabel("Department:");
        lblDept.setBounds(30, 150, 100, 25);
        frame.add(lblDept);

        String[] depts = {"CSE", "IT", "ECE", "EEE", "Mechanical"};
        JComboBox<String> cbDept = new JComboBox<>(depts);
        cbDept.setBounds(140, 150, 180, 25);
        frame.add(cbDept);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(140, 200, 100, 30);
        btnSubmit.addActionListener(e -> {
            String name = txtName.getText();
            String regNo = txtReg.getText();
            String gender = rbMale.isSelected() ? "Male" : (rbFemale.isSelected() ? "Female" : "Not Selected");
            String dept = (String) cbDept.getSelectedItem();

            String info = "Name: " + name + "\nRegister No: " + regNo + "\nGender: " + gender + "\nDepartment: " + dept;
            JOptionPane.showMessageDialog(frame, info, "Registration Details", JOptionPane.INFORMATION_MESSAGE);
        });
        frame.add(btnSubmit);

        frame.setVisible(true);
    }
}
