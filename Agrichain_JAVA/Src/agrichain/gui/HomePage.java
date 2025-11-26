package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

public class HomePage extends Frame implements ActionListener, MouseListener {

    Label title, subtitle;
    Button loginBtn, signupBtn;
    TextArea statusArea;

    public HomePage() {

        setTitle("AgriChain - Home");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(false);

        Color bg = new Color(10, 10, 10);
        setBackground(bg);

        Font titleFont = new Font("Arial", Font.BOLD, 55);
        Font subFont = new Font("Arial", Font.PLAIN, 22);
        Font btnFont = new Font("Arial", Font.BOLD, 26);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screen.width;
        int h = screen.height;

        title = new Label("AGRICHAIN");
        title.setFont(titleFont);
        title.setForeground(new Color(0, 255, 136));
        title.setBounds(w / 2 - 250, 100, 500, 60);
        add(title);

        subtitle = new Label("Smart Agriculture Supply-Chain Management System");
        subtitle.setFont(subFont);
        subtitle.setForeground(Color.WHITE);
        subtitle.setBounds(w / 2 - 350, 170, 700, 40);
        add(subtitle);

        loginBtn = new Button("LOGIN");
        loginBtn.setFont(btnFont);
        loginBtn.setBackground(new Color(30, 30, 30));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBounds(w / 2 - 220, h / 2 - 30, 180, 60);
        loginBtn.addActionListener(this);
        loginBtn.addMouseListener(this);
        add(loginBtn);

        signupBtn = new Button("SIGN UP");
        signupBtn.setFont(btnFont);
        signupBtn.setBackground(new Color(30, 30, 30));
        signupBtn.setForeground(Color.WHITE);
        signupBtn.setBounds(w / 2 + 40, h / 2 - 30, 180, 60);
        signupBtn.addActionListener(this);
        signupBtn.addMouseListener(this);
        add(signupBtn);

        statusArea = new TextArea();
        statusArea.setEditable(false);
        statusArea.setBackground(new Color(15, 15, 15));
        statusArea.setForeground(new Color(0, 255, 136));
        statusArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        statusArea.setBounds(40, h - 200, w - 80, 140);
        statusArea.setText("Status: Welcome to AgriChain");
        add(statusArea);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {
            statusArea.setText("Status: Login button clicked");
            new LoginGui();   // when ready
            dispose();
        }

        if (e.getSource() == signupBtn) {
            statusArea.setText("Status: Signup button clicked");
            new SignUpGUI();
            dispose();
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
        new HomePage();
    }
}
