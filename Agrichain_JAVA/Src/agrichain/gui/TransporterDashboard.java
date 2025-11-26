package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

public class TransporterDashboard extends Frame implements ActionListener {

    Label title, bottomCanvas;
    Button viewBtn, deliverBtn, backBtn;

    public TransporterDashboard() {

        setTitle("Transporter Dashboard");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font btnFont = new Font("Arial", Font.BOLD, 22);

        title = new Label("TRANSPORTER DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 350, h/6, 700, 60);
        add(title);

        viewBtn = new Button("VIEW ASSIGNED ORDERS");
        viewBtn.setFont(btnFont);
        viewBtn.setBackground(new Color(0,255,150));
        viewBtn.setBounds(w/2 - 350, h/3, 300, 60);
        viewBtn.addActionListener(this);
        add(viewBtn);

        deliverBtn = new Button("DELIVER ORDER");
        deliverBtn.setFont(btnFont);
        deliverBtn.setBackground(Color.darkGray);
        deliverBtn.setForeground(Color.white);
        deliverBtn.setBounds(w/2 + 50, h/3, 300, 60);
        deliverBtn.addActionListener(this);
        add(deliverBtn);

        backBtn = new Button("BACK");
        backBtn.setFont(btnFont);
        backBtn.setBackground(Color.gray);
        backBtn.setBounds(w/2 - 100, h/3 + 120, 200, 50);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Transport Operations");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 80, w, 50);
        add(bottomCanvas);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == viewBtn){
            System.out.println("View Transport Orders clicked");
        }
        if(e.getSource() == deliverBtn){
            System.out.println("Delivery Thread started");
        }
        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }
    
}
