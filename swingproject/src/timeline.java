import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

public class timeline extends JFrame {
    private final JTextField dobField;
    private final JTextArea timelineArea;

    public timeline() {
        setTitle("Timeline App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set it to EXIT_ON_CLOSE for standalone use
        setSize(500, 150);

        JPanel panel = new JPanel();
        add(panel);

        JLabel label = new JLabel("Enter Date of Birth:");
        dobField = new JTextField(10);
        JButton submitButton = new JButton("Submit");
        timelineArea = new JTextArea(10, 30);

        panel.add(label);
        panel.add(dobField);
        panel.add(submitButton);
        panel.add(timelineArea);

        // Define a custom date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Timer timer = new Timer(1000, e -> {
            // Get the entered date of birth from the text field
            String dobText = dobField.getText();

            try {
                LocalDate dob = LocalDate.parse(dobText, formatter);

                // Calculate the age in years, months, days, hours, minutes, and seconds
                LocalDateTime currentDateTime = LocalDateTime.now();
                LocalDateTime dobDateTime = dob.atStartOfDay();
                Duration duration = Duration.between(dobDateTime, currentDateTime);
                Period age = Period.between(dob, currentDateTime.toLocalDate());

                timelineArea.setText("Your age is " + age.getYears() + " years, " + age.getMonths() + " months, " +
                        age.getDays() + " days, " + duration.toHours() + " hours, " +
                        duration.toMinutes() % 60 + " minutes, and " + duration.getSeconds() + " seconds.");
            } catch (java.time.format.DateTimeParseException ex) {
                timelineArea.setText("Invalid date format. Please use the format 'dd-MM-yyyy'.");
            }
        });

        submitButton.addActionListener(e -> timer.start());
    }

    public void startTimelineApp() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            timeline app = new timeline();
            app.setVisible(true);
        });
    }
}
