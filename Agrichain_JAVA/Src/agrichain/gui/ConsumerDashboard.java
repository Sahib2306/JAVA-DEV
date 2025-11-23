package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

import agrichain.service.ConsumerService;

public class ConsumerDashboard extends Frame implements ActionListener {

    Label lbTitle;
    Button btnHistory, btnBack;

    ConsumerService cs = new ConsumerService();
    String cid;

    public ConsumerDashboard(String id) {
        cid = id;

        this.setTitle("Consumer Dashboard - " + id);
        this.setSize(400, 300);
        Color c = new Color(30, 30, 30);
        this.setBackground(c);
        this.setVisible(true);
        this.setLayout(null);

        Font f1 = new Font("Arial", Font.BOLD, 20);

        lbTitle = new Label("Consumer Dashboard");
        lbTitle.setBounds(110, 50, 250, 30);
        lbTitle.setFont(f1);
        Color foreGround = Color.WHITE;
        lbTitle.setForeground(foreGround);
        this.add(lbTitle);

        btnHistory = new Button("View History");
        btnHistory.setBounds(120, 140, 100, 30);
        btnHistory.addActionListener(this);
        add(btnHistory);

        btnBack = new Button("Back");
        btnBack.setBounds(240, 140, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnHistory) {
            cs.history(cid);
        }

        if (e.getSource() == btnBack) {
            dispose();
            new LoginGui();
        }
    }
}