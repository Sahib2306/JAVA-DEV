package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import agrichain.model.Crop;
import agrichain.service.FarmerService;

public class FarmerDashboard extends Frame implements ActionListener {

    Label lblTitle, lblCname, lblQty, lblPrice;
    TextField txtCname, txtQty, txtPrice;
    Button btnAdd, btnOrders, btnBack;

    FarmerService fs = new FarmerService();
    String farmerId;

    public FarmerDashboard(String id) {
        farmerId = id;

        setTitle("Farmer Dashboard - " + id);
        setSize(450,400);
        setLayout(null);
        setBackground(new Color(30,30,30));
        setVisible(true);

        Font f1 = new Font("Arial",Font.BOLD,20);
        Font f2 = new Font("Arial",Font.BOLD,16);

        lblTitle = new Label("Farmer Dashboard");
        lblTitle.setBounds(120,50,250,30);
        lblTitle.setFont(f1);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        lblCname = new Label("Crop Name:");
        lblCname.setBounds(60,120,120,25);
        lblCname.setFont(f2);
        lblCname.setForeground(Color.WHITE);
        add(lblCname);

        txtCname = new TextField();
        txtCname.setBounds(190,120,180,25);
        add(txtCname);

        lblQty = new Label("Quantity:");
        lblQty.setBounds(60,160,120,25);
        lblQty.setFont(f2);
        lblQty.setForeground(Color.WHITE);
        add(lblQty);

        txtQty = new TextField();
        txtQty.setBounds(190,160,180,25);
        add(txtQty);

        lblPrice = new Label("Price:");
        lblPrice.setBounds(60,200,120,25);
        lblPrice.setFont(f2);
        lblPrice.setForeground(Color.WHITE);
        add(lblPrice);

        txtPrice = new TextField();
        txtPrice.setBounds(190,200,180,25);
        add(txtPrice);

        btnAdd = new Button("Add Crop");
        btnAdd.setBounds(70,260,100,30);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnOrders = new Button("View Orders");
        btnOrders.setBounds(180,260,100,30);
        btnOrders.addActionListener(this);
        add(btnOrders);

        btnBack = new Button("Back");
        btnBack.setBounds(290,260,80,30);
        btnBack.addActionListener(this);
        add(btnBack);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAdd) {
            String name = txtCname.getText();
            double qty = Double.parseDouble(txtQty.getText());
            double price = Double.parseDouble(txtPrice.getText());

            Crop c = new Crop("TEMP", name, qty, price);
            fs.saveCrop(c);

            System.out.println("Crop Added -> " + name);
        }
        if(e.getSource()==btnOrders) {
            fs.showOrders();
        }
        if(e.getSource()==btnBack) {
            dispose();
            new LoginGui();
        }
    }
}
