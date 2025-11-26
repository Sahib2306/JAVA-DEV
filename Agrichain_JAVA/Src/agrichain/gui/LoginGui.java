package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

public class LoginGui extends Frame implements ActionListener {

    Label titleLabel, uidLabel, passLabel, roleLabel, bottomCanvas;
    TextField uidField, passField;
    Choice roleChoice;
    Button loginBtn, signupBtn;

    public LoginGui() {

        setTitle("AgriChain - Login");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH); // fullscreen
        setBackground(Color.black);
        setVisible(true);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screen.width;
        int h = screen.height;

        Font titleFont = new Font("Arial", Font.BOLD, 60);
        Font labelFont = new Font("Arial", Font.BOLD, 22);
        Font btnFont = new Font("Arial", Font.BOLD, 22);

        titleLabel = new Label("AGRICHAIN");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(0, 255, 150));
        titleLabel.setBounds(w / 10, h / 3, 500, 70);
        add(titleLabel);

        uidLabel = new Label("User ID:");
        uidLabel.setFont(labelFont);
        uidLabel.setForeground(Color.white);
        uidLabel.setBounds(w - 550, h / 3 - 40, 150, 30);
        add(uidLabel);

        uidField = new TextField();
        uidField.setBounds(w - 380, h / 3 - 40, 250, 30);
        add(uidField);

        passLabel = new Label("Password:");
        passLabel.setFont(labelFont);
        passLabel.setForeground(Color.white);
        passLabel.setBounds(w - 550, h / 3 + 10, 150, 30);
        add(passLabel);

        passField = new TextField();
        passField.setEchoChar('*');
        passField.setBounds(w - 380, h / 3 + 10, 250, 30);
        add(passField);

        roleLabel = new Label("Role:");
        roleLabel.setFont(labelFont);
        roleLabel.setForeground(Color.white);
        roleLabel.setBounds(w - 550, h / 3 + 60, 150, 30);
        add(roleLabel);

        roleChoice = new Choice();
        roleChoice.add("FARMER");
        roleChoice.add("BUYER");
        roleChoice.add("CONSUMER");
        roleChoice.add("TRANSPORTER");
        roleChoice.setBounds(w - 380, h / 3 + 60, 250, 30);
        add(roleChoice);

        loginBtn = new Button("LOGIN");
        loginBtn.setFont(btnFont);
        loginBtn.setBackground(new Color(0, 255, 150));
        loginBtn.setForeground(Color.black);
        loginBtn.setBounds(w - 500, h / 3 + 130, 150, 45);
        loginBtn.addActionListener(this);
        add(loginBtn);

        signupBtn = new Button("SIGN UP");
        signupBtn.setFont(btnFont);
        signupBtn.setBackground(Color.darkGray);
        signupBtn.setForeground(Color.white);
        signupBtn.setBounds(w - 300, h / 3 + 130, 150, 45);
        signupBtn.addActionListener(this);
        add(signupBtn);

        bottomCanvas = new Label("AgriChain — Smart Agricultural Supply Chain Management");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setFont(new Font("Arial", Font.PLAIN, 18));
        bottomCanvas.setBackground(new Color(10, 10, 10));
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 80, w, 50); // visible above taskbar
        add(bottomCanvas);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {
            String role = roleChoice.getSelectedItem();

            if (role.equals("FARMER")) {
                new FarmerDashboard();
            }
            else if (role.equals("BUYER")) {
                new BuyerDashboard();
            } 
            else if (role.equals("CONSUMER")) {
                new ConsumerDashboard();
            } 
            else if (role.equals("TRANSPORTER")) {
                new TransporterDashboard();
            }

            dispose(); // close login
        }

        if (e.getSource() == signupBtn) {
            System.out.println("Sign Up clicked");
            new SignUpGUI();
            dispose();
        }
    }

    public static void main(String[] args) {
        new LoginGui();
    }
}
