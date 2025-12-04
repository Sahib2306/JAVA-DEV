package agrichain.main;

import agrichain.gui.HomePage;
import javax.swing.*;
import java.awt.*;

public class AgriChainMain {

    public static void main(String[] args) {

        System.out.println("Launching AgriChain...");

        // Load UI on Event Dispatch Thread (best practice for Swing)
        SwingUtilities.invokeLater(() -> createWelcomeScreen());
    }

    private static void createWelcomeScreen() {

        // ===== CREATE FRAME =====
        JFrame welcome = new JFrame("Welcome to AgriChain");
        welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setLayout(new BorderLayout());

        // ===== BACKGROUND IMAGE =====
        JLabel imgLabel = new JLabel("", JLabel.CENTER);
        ImageIcon icon = loadImage("img.jpeg");

        if (icon != null) {
            imgLabel.setIcon(scaleImage(icon));
        } else {
            imgLabel.setText("AgriChain");
            imgLabel.setFont(new Font("Arial", Font.BOLD, 52));
            imgLabel.setForeground(new Color(0, 120, 0));
        }

        welcome.add(imgLabel, BorderLayout.CENTER);

        // ===== "GET STARTED" BUTTON =====
        JButton startBtn = new JButton("Get Started");
        startBtn.setFont(new Font("SansSerif", Font.BOLD, 32));
        styleButton(startBtn);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 40, 10));
        bottomPanel.add(startBtn);

        welcome.add(bottomPanel, BorderLayout.SOUTH);

        // ===== BUTTON ACTION =====
        startBtn.addActionListener(e -> {
            welcome.dispose();
            new HomePage(); // open next window
        });

        welcome.setVisible(true);
    }

    // ===== IMAGE LOADING FUNCTION =====
    private static ImageIcon loadImage(String fileName) {
        try {
            return new ImageIcon(AgriChainMain.class.getResource(fileName));
        } catch (Exception e) {
            System.out.println("❌ Image not found: " + fileName);
            return null;
        }
    }

    // ===== IMAGE SCALING FUNCTION =====
    private static ImageIcon scaleImage(ImageIcon icon) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Image scaled = icon.getImage().getScaledInstance(
                screen.width,
                screen.height - 150,
                Image.SCALE_SMOOTH
        );
        return new ImageIcon(scaled);
    }

    // ===== BUTTON UI IMPROVEMENT =====
    private static void styleButton(JButton btn) {
        btn.setPreferredSize(new Dimension(300, 80));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(34, 139, 34));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(new Color(20, 90, 20), 3, true));
    }
}
