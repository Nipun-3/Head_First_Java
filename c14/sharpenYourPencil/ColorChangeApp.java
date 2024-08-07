package c14.sharpenYourPencil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorChangeApp {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Color Change Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create the drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel, BorderLayout.CENTER);

        // Create the button
        JButton button = new JButton("Change Color");
        frame.add(button, BorderLayout.SOUTH);

        // Register the listener with the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.changeColor();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}

class DrawingPanel extends JPanel {
    private Color circleColor;

    public DrawingPanel() {
        changeColor();
    }

    public void changeColor() {
        // Generate a random color
        Random rand = new Random();
        circleColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        // Repaint the panel
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint the circle with the current color
        g.setColor(circleColor);
        g.fillOval(100, 100, 200, 200);
    }
}
