import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class medium extends JFrame {
    public medium() {
        setTitle("Main Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change the default close operation
        setSize(400, 150);
        setLayout(new GridLayout(3, 2));

        JButton openTimelineButton = new JButton("Open Timeline App");
        openTimelineButton.addActionListener(e -> openTimelineApp());

        JButton openImagedisButton = new JButton("Open Image Recognition App");
        openImagedisButton.addActionListener(e -> openImagedisApp());
        JButton openregisButton = new JButton("Open Registration App");
        openregisButton.addActionListener(e -> openRegisApp()); // Corrected the method name

        add(openTimelineButton);
        add(openImagedisButton);
        add(openregisButton);

        setVisible(true);
    }

    private void openTimelineApp() {
        // Create and open the TimelineApp class or frame
        timeline timelineFrame = new timeline(); // Create a new instance of the TimelineApp frame
        timelineFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change the default close operation
        timelineFrame.setVisible(true); // Set its visibility
    }

    private void openImagedisApp() {
        // Create and open the imagedis class or frame
        imagedis imagedisApp = new imagedis();
        imagedisApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change the default close operation
        imagedisApp.setVisible(true);
    }

    private void openRegisApp() { // Corrected method name
        // Create and open the regis class or frame
        regis regisapp = new regis();
        regisapp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change the default close operation
        regisapp.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(medium::new);
    }
}
