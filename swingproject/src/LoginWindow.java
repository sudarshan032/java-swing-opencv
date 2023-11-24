import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginWindow() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            if (verifyCredentials(username, new String(password))) {
                openImageRecognitionWindow();
            } else {
                JOptionPane.showMessageDialog(LoginWindow.this, "Incorrect credentials. Please try again.");
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty label for spacing
        add(loginButton);

        setVisible(true);
    }

    private boolean verifyCredentials(String username, String password) {
        // Replace this with your actual credential verification logic
        // Return true if credentials are correct, otherwise return false.
        // Example: check against a predefined username and password.
        return username.equals("123") && password.equals("123");
    }

    private void openImageRecognitionWindow() {
        medium app = new medium();
        app.setVisible(true);
        dispose(); // Close the login window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginWindow::new);
    }
}
