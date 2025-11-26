package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

public class ConsumerDashboard extends Frame implements ActionListener {

    Label title, bottomCanvas;
    Button viewBtn, backBtn;

    public ConsumerDashboard() {

        setTitle("Consumer Dashboard");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font btnFont = new Font("Arial", Font.BOLD, 22);

        title = new Label("CONSUMER DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 300, h/6, 600, 60);
        add(title);

        viewBtn = new Button("VIEW ORDERS");
        viewBtn.setFont(btnFont);
        viewBtn.setBackground(new Color(0,255,150));
        viewBtn.setBounds(w/2 - 140, h/3, 280, 60);
        viewBtn.addActionListener(this);
        add(viewBtn);

        backBtn = new Button("BACK");
        backBtn.setFont(btnFont);
        backBtn.setBackground(Color.gray);
        backBtn.setBounds(w/2 - 140, h/3 + 120, 280, 50);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Consumer Operations");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 80, w, 50);
        add(bottomCanvas);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == viewBtn){
            System.out.println("View order history clicked");
        }
        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }
}
