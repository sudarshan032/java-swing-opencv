import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regis extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox<String> countryComboBox;
    private JCheckBox readingCheckBox;
    private JCheckBox swimmingCheckBox;
    private JCheckBox travelingCheckBox;
    private JTextArea feedbackTextArea;

    public regis() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400); // Increased the height to accommodate all components.

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        addComponent(formPanel, new JLabel("Name:"), constraints, 0, 0);
        nameField = new JTextField(20);
        addComponent(formPanel, nameField, constraints, 1, 0);

        addComponent(formPanel, new JLabel("Email:"), constraints, 0, 1);
        emailField = new JTextField(20);
        addComponent(formPanel, emailField, constraints, 1, 1);

        addComponent(formPanel, new JLabel("Password:"), constraints, 0, 2);
        passwordField = new JPasswordField(20);
        addComponent(formPanel, passwordField, constraints, 1, 2);

        addComponent(formPanel, new JLabel("Gender:"), constraints, 0, 3);
        JPanel genderPanel = new JPanel();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        addComponent(formPanel, genderPanel, constraints, 1, 3);

        addComponent(formPanel, new JLabel("Country:"), constraints, 0, 4);
        String[] countries = {"Select", "USA", "Canada", "UK", "Other"};
        countryComboBox = new JComboBox<>(countries);
        addComponent(formPanel, countryComboBox, constraints, 1, 4);

        addComponent(formPanel, new JLabel("Hobbies:"), constraints, 0, 5);
        JPanel hobbiesPanel = new JPanel();
        readingCheckBox = new JCheckBox("Reading");
        swimmingCheckBox = new JCheckBox("Swimming");
        travelingCheckBox = new JCheckBox("Traveling");
        hobbiesPanel.add(readingCheckBox);
        hobbiesPanel.add(swimmingCheckBox);
        hobbiesPanel.add(travelingCheckBox);
        addComponent(formPanel, hobbiesPanel, constraints, 1, 5);

        addComponent(formPanel, new JLabel("Feedback:"), constraints, 0, 6);
        feedbackTextArea = new JTextArea(5, 20);
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackTextArea);
        addComponent(formPanel, feedbackScrollPane, constraints, 1, 6);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle form submission here
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String country = (String) countryComboBox.getSelectedItem();
                String feedback = feedbackTextArea.getText();

                StringBuilder hobbies = new StringBuilder();
                if (readingCheckBox.isSelected()) {
                    hobbies.append("Reading, ");
                }
                if (swimmingCheckBox.isSelected()) {
                    hobbies.append("Swimming, ");
                }
                if (travelingCheckBox.isSelected()) {
                    hobbies.append("Traveling");
                }

                JOptionPane.showMessageDialog(regis.this, "Registration Details:\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Password: " + password + "\n" +
                        "Gender: " + gender + "\n" +
                        "Country: " + country + "\n" +
                        "Hobbies: " + hobbies + "\n" +
                        "Feedback: " + feedback);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void addComponent(Container container, Component component, GridBagConstraints constraints, int gridx, int gridy) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        container.add(component, constraints);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new regis();
            }
        });
    }
}
