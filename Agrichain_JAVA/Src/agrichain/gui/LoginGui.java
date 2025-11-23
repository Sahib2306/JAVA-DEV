package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import agrichain.service.AuthService;

public class LoginGui extends Frame implements ActionListener {

    Label lblTitle, lblUser, lblPass, lblRole;
    TextField txtUser, txtPass;
    Choice roleChoice;
    Button btnLogin, btnExit;

    AuthService as = new AuthService();

    public LoginGui() {

        setTitle("AgriChain Login");
        setSize(400, 350);
        setLayout(null);
        setBackground(new Color(30,30,30));

        Font f1 = new Font("Arial", Font.BOLD, 20);
        Font f2 = new Font("Arial", Font.BOLD, 16);

        lblTitle = new Label("AgriChain Login");
        lblTitle.setBounds(120, 50, 200, 30);
        lblTitle.setFont(f1);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        lblUser = new Label("User ID:");
        lblUser.setBounds(60,110,100,25);
        lblUser.setFont(f2);
        lblUser.setForeground(Color.WHITE);
        add(lblUser);

        txtUser = new TextField();
        txtUser.setBounds(160,110,180,25);
        add(txtUser);

        lblPass = new Label("Password:");
        lblPass.setBounds(60,150,100,25);
        lblPass.setFont(f2);
        lblPass.setForeground(Color.WHITE);
        add(lblPass);

        txtPass = new TextField();
        txtPass.setBounds(160,150,180,25);
        txtPass.setEchoChar('*');
        add(txtPass);

        lblRole = new Label("Role:");
        lblRole.setBounds(60,190,100,25);
        lblRole.setFont(f2);
        lblRole.setForeground(Color.WHITE);
        add(lblRole);

        roleChoice = new Choice();
        roleChoice.add("FARMER");
        roleChoice.add("BUYER");
        roleChoice.add("CONSUMER");
        roleChoice.add("TRANSPORTER");
        roleChoice.setBounds(160,190,180,25);
        add(roleChoice);

        btnLogin = new Button("Login");
        btnLogin.setBounds(120,240,70,30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnExit = new Button("Exit");
        btnExit.setBounds(210,240,70,30);
        btnExit.addActionListener(this);
        add(btnExit);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnLogin) {

            String id = txtUser.getText();
            String pass = txtPass.getText();
            String role = roleChoice.getSelectedItem();

            boolean ok = as.login(id, pass, role);

            if(ok) {
                System.out.println("Login Success!");

                if(role.equals("FARMER")) {
                    new FarmerDashboard(id);
                    dispose();
                }
                else if(role.equals("BUYER")) {
                    new BuyerDashboard(id);
                    dispose();
                }
                else if(role.equals("CONSUMER")) {
                    new ConsumerDashboard(id);
                    dispose();
                }
                else if(role.equals("TRANSPORTER")) {
                    new TransporterDashboard(id);
                    dispose();
                }
            }
            else {
                System.out.println("Login Failed!");
            }
        }

        if(e.getSource() == btnExit) {
            dispose();
        }
    }
}
