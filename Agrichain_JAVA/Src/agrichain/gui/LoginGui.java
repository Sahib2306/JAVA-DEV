package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import agrichain.service.AuthService;

public class LoginGui extends Frame implements ActionListener {

    Label titleLabel, userLabel, passLabel, roleLabel;
    TextField userField, passField;
    Choice roleChoice;
    Button loginBtn, exitBtn;

    AuthService as = new AuthService();   // service object

    public LoginGui() {

        // Frame settings
        this.setTitle("AgriChain Login");
        this.setSize(400, 350);
        this.setLayout(null);
        Color c = new Color(30,30,30);
        this.setBackground(c);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.BOLD, 16);

        // Title
        titleLabel = new Label("Agrichain Login");
        titleLabel.setBounds(120, 50, 200, 30);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        this.add(titleLabel);

        // User label + field
        userLabel = new Label("User ID:");
        userLabel.setBounds(60, 110, 100, 25);
        userLabel.setFont(labelFont);
        userLabel.setForeground(Color.WHITE);
        this.add(userLabel);

        userField = new TextField();
        userField.setBounds(160, 110, 180, 25);
        this.add(userField);

        // Password label + field
        passLabel = new Label("Password:");
        passLabel.setBounds(60, 150, 100, 25);
        passLabel.setFont(labelFont);
        passLabel.setForeground(Color.WHITE);
        this.add(passLabel);

        passField = new TextField();
        passField.setBounds(160, 150, 180, 25);
        passField.setEchoChar('*');
        this.add(passField);

        // Role label
        roleLabel = new Label("Role:");
        roleLabel.setBounds(60, 190, 100, 25);   // FIXED (previously 250 height)
        roleLabel.setFont(labelFont);
        roleLabel.setForeground(Color.WHITE);
        this.add(roleLabel);

        // Role dropdown
        roleChoice = new Choice();
        roleChoice.add("FARMER");
        roleChoice.add("BUYER");
        roleChoice.add("CONSUMER");
        roleChoice.add("TRANSPORTER");
        roleChoice.setBounds(160, 190, 180, 25);
        this.add(roleChoice);

        // Buttons
        loginBtn = new Button("Login");
        loginBtn.setBounds(120, 240, 70, 30);
        loginBtn.addActionListener(this);
        this.add(loginBtn);

        exitBtn = new Button("Exit");
        exitBtn.setBounds(210, 240, 70, 30);
        exitBtn.addActionListener(this);
        this.add(exitBtn);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        this.setVisible(true);
    }

    // Button actions
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {

            String id = userField.getText();
            String pass = passField.getText();
            String role = roleChoice.getSelectedItem();

            // Temporary login check using AuthService
            boolean ok = as.login(id, pass, role);

            if (ok) {
                System.out.println("Login Success!");

                if(role.equals("FARMER")){
                    new FarmerDashboard(id);
                    dispose();
                }
            } else {
                System.out.println("Login Failed!");
            }
        }

        if (e.getSource() == exitBtn) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new LoginGui();
    }
}
