package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

import agrichain.model.Order;
import agrichain.service.BuyerService;

public class BuyerDashboard extends Frame implements ActionListener {

    Label lblTitle, lblCropId, lblQty;
    TextField txtCropId, txtQty;
    Button btnPlace, btnView, btnBack;

    BuyerService bs = new BuyerService();
    String buyerId;

    public BuyerDashboard(String id) {
        buyerId = id;

        setTitle("Buyer Dashboard - " + id);
        setSize(450,350);
        setLayout(null);
        setBackground(new Color(30,30,30));
        setVisible(true);

        Font f1 = new Font("Arial",Font.BOLD,20);
        Font f2 = new Font("Arial",Font.BOLD,16);

        lblTitle = new Label("Buyer Dashboard");
        lblTitle.setBounds(130,50,220,30);
        lblTitle.setFont(f1);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        lblCropId = new Label("Crop ID:");
        lblCropId.setBounds(60,120,100,25);
        lblCropId.setFont(f2);
        lblCropId.setForeground(Color.WHITE);
        add(lblCropId);

        txtCropId = new TextField();
        txtCropId.setBounds(170,120,180,25);
        add(txtCropId);

        lblQty = new Label("Quantity:");
        lblQty.setBounds(60,160,100,25);
        lblQty.setFont(f2);
        lblQty.setForeground(Color.WHITE);
        add(lblQty);

        txtQty = new TextField();
        txtQty.setBounds(170,160,180,25);
        add(txtQty);

        btnPlace = new Button("Place Order");
        btnPlace.setBounds(70,220,100,30);
        btnPlace.addActionListener(this);
        add(btnPlace);

        btnView = new Button("View Crops");
        btnView.setBounds(180,220,100,30);
        btnView.addActionListener(this);
        add(btnView);

        btnBack = new Button("Back");
        btnBack.setBounds(290,220,80,30);
        btnBack.addActionListener(this);
        add(btnBack);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){ dispose(); }
        });
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnPlace) {
            String cropId = txtCropId.getText();
            double qty = Double.parseDouble(txtQty.getText());

            Order o = new Order("TEMP", buyerId, cropId, qty, "PENDING");
            bs.makeOrder(o);
            System.out.println("Order placed");
        }

        if(e.getSource()==btnView) {
            bs.showCrops();
        }

        if(e.getSource()==btnBack) {
            dispose();
            new LoginGui();
        }
    }
}
