package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

import agrichain.model.Order;
import agrichain.service.TransporterService;


public class TransporterDashboard extends Frame implements ActionListener{
    
    Label lbtitle, lbOrderId;
    TextField txtOrderId;
    Button btnDeliver, btnStatus, btnBack;

    TransporterService ts = new TransporterService();
    String tid;

    public TransporterDashboard( String id){
        tid = id;

        this.setTitle("Transporter Dashboard - "+id);
        this.setSize(450,320);
        this.setLayout(null);
        Color background = new Color(30,30,30);
        this.setBackground(background);
        this.setVisible(true);


        Font f1 = new Font("Arial",Font.BOLD,20);
        Font f2 = new Font("Arial",Font.BOLD,16);

        lbtitle = new Label("Transporter Dashboard");
        lbtitle.setBounds(110,50,260,30);
        lbtitle.setFont(f1);
        Color c = Color.WHITE;
        lbtitle.setBackground(c);
        this.add(lbtitle);

        lbOrderId = new Label("Order ID: ");
        lbOrderId.setBounds(60,130,120,25);
        lbOrderId.setForeground(c);
        lbOrderId.setFont(f2);
        this.add(lbOrderId);

        txtOrderId = new TextField();
        txtOrderId.setBounds(70,200,100,30);
        this.add(txtOrderId);

        btnDeliver = new Button("Deliver");
        btnDeliver.setBounds(70,200,100,30);
        btnDeliver.addActionListener(this);
        add(btnDeliver);

        btnStatus = new Button("Status");
        btnStatus.setBounds(180,200,100,30);
        btnStatus.addActionListener(this);
        add(btnStatus);

        btnBack = new Button("Back");
        btnBack.setBounds(290,200,80,30);
        btnBack.addActionListener(this);
        add(btnBack);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btnDeliver){
            Order o = new Order(txtOrderId.getText(),"buyer","crop",0,"PENDING");
            ts.deliver(o);
        }
        if(e.getSource()==btnStatus) {
            Order o = new Order(txtOrderId.getText(), "buyer", "crop", 0, "PENDING");
            ts.status(o);
        }
        if(e.getSource()==btnBack) {
            dispose();
            new LoginGui();
        }

    }
    public static void main(String[] args) {
        new TransporterDashboard(null);
    }
}
