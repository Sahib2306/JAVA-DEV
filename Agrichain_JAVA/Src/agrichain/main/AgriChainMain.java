package agrichain.main;

import agrichain.gui.HomePage;
import javax.swing.*;
import java.awt.*;

public class AgriChainMain {

    public static void main(String[] args) {

        System.out.println("Launching AgriChain...");

        // ===== FULLSCREEN FRAME =====
        JFrame welcome = new JFrame("Welcome to AgriChain");
        welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);   // Full screen
        welcome.setUndecorated(false);                     // Keep title bar (you can set true if you want borderless)
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setLayout(new BorderLayout());

        // ===== IMAGE LABEL =====
        JLabel imgLabel = new JLabel("", JLabel.CENTER);

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(AgriChainMain.class.getResource("img.jpeg"));
        } catch (Exception e) {
            System.out.println("❌ Image not found!");
        }

        if (icon != null) {
            // Scale image to full screen size
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Image scaledImg = icon.getImage().getScaledInstance(
                    screenSize.width,
                    screenSize.height - 150,
                    Image.SCALE_SMOOTH
            );
            imgLabel.setIcon(new ImageIcon(scaledImg));
        } else {
            imgLabel.setText("AgriChain");
            imgLabel.setFont(new Font("Arial", Font.BOLD, 50));
        }

        welcome.add(imgLabel, BorderLayout.CENTER);

        // ===== "GET STARTED" BUTTON =====
        JButton startBtn = new JButton("Get Started");
        startBtn.setFont(new Font("Arial", Font.BOLD, 32));
        startBtn.setPreferredSize(new Dimension(300, 80));
        startBtn.setFocusPainted(false);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 40, 10));
        bottomPanel.add(startBtn);

        welcome.add(bottomPanel, BorderLayout.SOUTH);

        // Action -> Open HomePage
        startBtn.addActionListener(e -> {
            welcome.dispose();
            new HomePage();
        });

        welcome.setVisible(true);
    }
}
