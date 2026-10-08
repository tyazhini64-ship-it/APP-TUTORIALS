import javax.swing.*;

public class week8qs4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Login");
        frame.setSize(350, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 30, 100, 25);
        frame.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(120, 30, 160, 25);
        frame.add(txtUser);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 70, 100, 25);
        frame.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(120, 70, 160, 25);
        frame.add(txtPass);

        JCheckBox chkRemember = new JCheckBox("Remember Me");
        chkRemember.setBounds(120, 110, 160, 25);
        frame.add(chkRemember);

        JCheckBox chkNotify = new JCheckBox("Receive Notifications");
        chkNotify.setBounds(120, 140, 160, 25);
        frame.add(chkNotify);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 180, 90, 30);
        btnLogin.addActionListener(e -> {
            String username = txtUser.getText();
            char[] password = txtPass.getPassword();
            if(!username.isEmpty() && password.length > 0) {
                JOptionPane.showMessageDialog(frame, "Login Successful for " + username + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter username and password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.add(btnLogin);

        frame.setVisible(true);
    }
}