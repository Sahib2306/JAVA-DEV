package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;

import agrichain.data.DBConnection;

public class SignUpGUI extends Frame implements ActionListener, MouseListener {

    Label title, idLabel, nameLabel, passLabel, roleLabel;
    TextField idField, nameField, passField;
    Choice roleChoice;
    Button registerBtn, backBtn;
    TextArea statusArea;

    public SignUpGUI() {

        setTitle("AgriChain - Sign Up");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(false);

        Color bg = new Color(10, 10, 10);
        setBackground(bg);

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font btnFont = new Font("Arial", Font.BOLD, 22);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screen.width;
        int h = screen.height;
        int centerX = w / 2;

        title = new Label("CREATE NEW ACCOUNT");
        title.setFont(titleFont);
        title.setForeground(new Color(0, 255, 136));
        title.setBounds(centerX - 250, 80, 500, 60);
        add(title);

        idLabel = new Label("User ID:");
        idLabel.setFont(labelFont);
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(centerX - 260, 190, 120, 30);
        add(idLabel);

        idField = new TextField();
        idField.setBounds(centerX - 120, 190, 260, 30);
        add(idField);

        nameLabel = new Label("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(centerX - 260, 240, 120, 30);
        add(nameLabel);

        nameField = new TextField();
        nameField.setBounds(centerX - 120, 240, 260, 30);
        add(nameField);

        passLabel = new Label("Password:");
        passLabel.setFont(labelFont);
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(centerX - 260, 290, 120, 30);
        add(passLabel);

        passField = new TextField();
        passField.setBounds(centerX - 120, 290, 260, 30);
        passField.setEchoChar('*');
        add(passField);

        roleLabel = new Label("Role:");
        roleLabel.setFont(labelFont);
        roleLabel.setForeground(Color.WHITE);
        roleLabel.setBounds(centerX - 260, 340, 120, 30);
        add(roleLabel);

        roleChoice = new Choice();
        roleChoice.add("FARMER");
        roleChoice.add("BUYER");
        roleChoice.add("CONSUMER");
        roleChoice.add("TRANSPORTER");
        roleChoice.setBounds(centerX - 120, 340, 260, 30);
        add(roleChoice);

        registerBtn = new Button("REGISTER");
        registerBtn.setFont(btnFont);
        registerBtn.setBackground(new Color(30, 30, 30));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setBounds(centerX - 260, 420, 180, 60);
        registerBtn.addActionListener(this);
        registerBtn.addMouseListener(this);
        add(registerBtn);

        backBtn = new Button("BACK");
        backBtn.setFont(btnFont);
        backBtn.setBackground(new Color(30, 30, 30));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(centerX + 20, 420, 180, 60);
        backBtn.addActionListener(this);
        backBtn.addMouseListener(this);
        add(backBtn);

        statusArea = new TextArea();
        statusArea.setEditable(false);
        statusArea.setBackground(new Color(15, 15, 15));
        statusArea.setForeground(new Color(0, 255, 136));
        statusArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        statusArea.setBounds(40, h - 200, w - 80, 140);
        statusArea.setText("Status: Fill details and click REGISTER");
        add(statusArea);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerBtn) {

            try {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                String pass = passField.getText().trim();
                String role = roleChoice.getSelectedItem();

                if(id.equals("") || name.equals("") || pass.equals("")) {
                    statusArea.setText("Status: Please fill all fields.");
                    return;
                }

                Connection con = DBConnection.getConn();
                Statement st = con.createStatement();

                String q = "INSERT INTO users VALUES('" + id + "','" + name + "','" + pass + "','" + role + "')";
                st.executeUpdate(q);

                statusArea.setText("Status: Registration Successful for ID: " + id);
                con.close();

            } catch(Exception ex) {
                statusArea.setText("Status: Registration Failed (maybe ID exists?)");
                ex.printStackTrace();
            }
        }

        if (e.getSource() == backBtn) {
            dispose();
            new HomePage();
        }
    }

    public void mouseEntered(MouseEvent e) {
        Button b = (Button)e.getSource();
        b.setBackground(new Color(0, 255, 136));
        b.setForeground(Color.black);
    }

    public void mouseExited(MouseEvent e) {
        Button b = (Button)e.getSource();
        b.setBackground(new Color(30, 30, 30));
        b.setForeground(Color.white);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        new SignUpGUI();
    }
}
