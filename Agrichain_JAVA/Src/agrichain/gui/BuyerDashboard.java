package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

public class BuyerDashboard extends Frame implements ActionListener {

    Label title, bottomCanvas;
    Button viewBtn, orderBtn, backBtn;

    public BuyerDashboard() {

        setTitle("Buyer Dashboard");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font btnFont = new Font("Arial", Font.BOLD, 22);

        title = new Label("BUYER DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 250, h/6, 500, 60);
        add(title);

        viewBtn = new Button("VIEW CROPS");
        viewBtn.setFont(btnFont);
        viewBtn.setBackground(new Color(0,255,150));
        viewBtn.setBounds(w/2 - 300, h/3, 250, 60);
        viewBtn.addActionListener(this);
        add(viewBtn);

        orderBtn = new Button("PLACE ORDER");
        orderBtn.setFont(btnFont);
        orderBtn.setBackground(Color.darkGray);
        orderBtn.setForeground(Color.white);
        orderBtn.setBounds(w/2 + 50, h/3, 250, 60);
        orderBtn.addActionListener(this);
        add(orderBtn);

        backBtn = new Button("BACK");
        backBtn.setFont(btnFont);
        backBtn.setBackground(Color.gray);
        backBtn.setBounds(w/2 - 100, h/3 + 120, 200, 50);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Buyer Operations");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 80, w, 50);
        add(bottomCanvas);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == viewBtn){
            System.out.println("View crops clicked");
        }
        if(e.getSource() == orderBtn){
            System.out.println("Place order clicked");
        }
        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }
    
}
