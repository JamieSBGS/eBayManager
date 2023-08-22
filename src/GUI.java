import javax.swing.*;
import java.awt.*;

public class GUI {
    private static final Dimension userScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Screen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int testWidth = userScreenSize.width / 2;
            int testHeight = userScreenSize.height / 2;

            // Create buttons
            JButton messageButton = new JButton("Message Generator");
            JButton inventoryButton = new JButton("Inventory Manager");

            // Create a label with an image
            ImageIcon imageIcon = new ImageIcon("ebaymanagerlogo.png"); // Check the image path
            JLabel imageLabel = new JLabel(imageIcon);

            // Set layout manager
            frame.setLayout(new BorderLayout());

            // Add buttons and image label to the content pane
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(messageButton);
            buttonPanel.add(inventoryButton);

            frame.add(buttonPanel, BorderLayout.NORTH);
            frame.add(imageLabel, BorderLayout.CENTER);

            frame.setSize(testWidth, testHeight);
            frame.setVisible(true);
        });
    }
}
