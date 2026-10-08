import java.awt.*;
import javax.swing.*;

class LoginView extends JFrame {
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private JButton submitLoginButton = new JButton("Login");

    public LoginView() {
        setTitle("Employee Portal - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Username:"));
        add(userField);
        add(new JLabel("Password:"));
        add(passField);
        add(new JLabel());
        add(submitLoginButton);
    }

    public String getUserInput() {
        return userField.getText();
    }

    public String getPasswordInput() {
        return new String(passField.getPassword());
    }

    public void addLoginAction(java.awt.event.ActionListener l) {
        submitLoginButton.addActionListener(l);
    }
}

class MainPortalView extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu employeeMenu = new JMenu("Employee");
    private JMenu toolsMenu = new JMenu("Tools");
    private JMenu exitMenu = new JMenu("Exit");

    private JMenuItem addEmpMenuItem = new JMenuItem("Add Employee");
    private JMenuItem viewEmpMenuItem = new JMenuItem("View Employee");
    private JMenuItem changePassMenuItem = new JMenuItem("Change Password");
    private JMenuItem logoutMenuItem = new JMenuItem("Logout");
    private JMenuItem exitAppMenuItem = new JMenuItem("Exit Application");

    public MainPortalView() {
        setTitle("Employee Management Portal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        employeeMenu.add(addEmpMenuItem);
        employeeMenu.add(viewEmpMenuItem);
        toolsMenu.add(changePassMenuItem);
        exitMenu.add(logoutMenuItem);
        exitMenu.add(exitAppMenuItem);

        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        menuBar.add(exitMenu);
        setJMenuBar(menuBar);
    }

    public void onAddEmployeeClick(java.awt.event.ActionListener l) { addEmpMenuItem.addActionListener(l); }
    public void onViewEmployeeClick(java.awt.event.ActionListener l) { viewEmpMenuItem.addActionListener(l); }
    public void onChangePasswordClick(java.awt.event.ActionListener l) { changePassMenuItem.addActionListener(l); }
    public void onLogoutClick(java.awt.event.ActionListener l) { logoutMenuItem.addActionListener(l); }
    public void onExitAppClick(java.awt.event.ActionListener l) { exitAppMenuItem.addActionListener(l); }
}

class PortalController {
    private LoginView loginWindow;

    public PortalController(LoginView loginWindow) {
        this.loginWindow = loginWindow;
        this.loginWindow.addLoginAction(e -> checkCredentials());
    }

    private void checkCredentials() {
        String enteredUser = loginWindow.getUserInput();
        String enteredPass = loginWindow.getPasswordInput();
        
        if (enteredUser.equals("admin") && enteredPass.equals("admin123")) {
            JOptionPane.showMessageDialog(loginWindow, "Welcome back, Admin!");
            loginWindow.dispose();
            launchDashboard();
        } else {
            JOptionPane.showMessageDialog(loginWindow, "Incorrect username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void launchDashboard() {
        MainPortalView dashboard = new MainPortalView();
        
        dashboard.onAddEmployeeClick(e -> {
            JTextField idBox = new JTextField(10);
            JTextField nameBox = new JTextField(10);
            JTextField deptBox = new JTextField(10);
            
            JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
            formPanel.add(new JLabel("Employee ID:")); formPanel.add(idBox);
            formPanel.add(new JLabel("Employee Name:")); formPanel.add(nameBox);
            formPanel.add(new JLabel("Department:")); formPanel.add(deptBox);
            
            int response = JOptionPane.showConfirmDialog(dashboard, formPanel, "Add New Employee", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(dashboard, "Employee record added successfully!");
            }
        });

        dashboard.onViewEmployeeClick(e -> {
            JOptionPane.showMessageDialog(dashboard, "Fetching employee list from database...", "View Employees", JOptionPane.INFORMATION_MESSAGE);
        });

        dashboard.onChangePasswordClick(e -> {
            JPasswordField oldBox = new JPasswordField(10);
            JPasswordField newBox = new JPasswordField(10);
            JPasswordField confirmBox = new JPasswordField(10);
            
            JPanel pwdPanel = new JPanel(new GridLayout(3, 2, 5, 5));
            pwdPanel.add(new JLabel("Old Password:")); pwdPanel.add(oldBox);
            pwdPanel.add(new JLabel("New Password:")); pwdPanel.add(newBox);
            pwdPanel.add(new JLabel("Confirm Password:")); pwdPanel.add(confirmBox);
            
            int response = JOptionPane.showConfirmDialog(dashboard, pwdPanel, "Change Password", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                String freshPass = new String(newBox.getPassword());
                String matchPass = new String(confirmBox.getPassword());
                
                if (freshPass.equals(matchPass)) {
                    JOptionPane.showMessageDialog(dashboard, "Password updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(dashboard, "New passwords do not match. Try again.", "Mismatch", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dashboard.onLogoutClick(e -> {
            dashboard.dispose();
            LoginView freshLogin = new LoginView();
            new PortalController(freshLogin);
            freshLogin.setVisible(true);
        });

        dashboard.onExitAppClick(e -> System.exit(0));
        dashboard.setVisible(true);
    }
}

public class week9qs3 {
    public static void main(String[] args) {
        LoginView window = new LoginView();
        new PortalController(window);
        window.setVisible(true);
    }
}