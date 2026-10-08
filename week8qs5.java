import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class week8qs5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Course Management System");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblCourses = new JLabel("Available Courses:");
        lblCourses.setBounds(20, 20, 150, 25);
        frame.add(lblCourses);

        String[] courses = {"Java Programming", "Data Structures", "Operating Systems", "Computer Architecture"};
        JList<String> listCourses = new JList<>(courses);
        JScrollPane scrollList = new JScrollPane(listCourses);
        scrollList.setBounds(20, 50, 180, 120);
        frame.add(scrollList);

        JLabel lblName = new JLabel("Student Name:");
        lblName.setBounds(220, 20, 100, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(320, 20, 180, 25);
        frame.add(txtName);

        String[] columns = {"Student Name", "Selected Course", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBounds(220, 60, 280, 150);
        frame.add(scrollTable);

        JButton btnAdd = new JButton("Add Registration");
        btnAdd.setBounds(20, 230, 180, 30);
        btnAdd.addActionListener(e -> {
            String name = txtName.getText();
            String course = listCourses.getSelectedValue();
            if(!name.isEmpty() && course != null) {
                model.addRow(new Object[]{name, course, "Enrolled"});
                txtName.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter student name and select a course.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        frame.add(btnAdd);

        JButton btnRemove = new JButton("Remove Selected");
        btnRemove.setBounds(220, 230, 180, 30);
        btnRemove.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row from the table to remove.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        frame.add(btnRemove);

        frame.setVisible(true);
    }
}