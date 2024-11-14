import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleSwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, World!");
        JButton button = new JButton("Click Me");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(button);

        // Create an ActionListener to handle button clicks
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    // Trigger button click using AWT Robot
                    Robot robot = new Robot();
                    Point buttonLocation = button.getLocationOnScreen();
                    robot.mouseMove(buttonLocation.x + button.getWidth() / 2, buttonLocation.y + button.getHeight() / 2);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        };

        // Add the ActionListener to the button
        button.addActionListener(actionListener);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}