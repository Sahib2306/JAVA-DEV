package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import agrichain.data.DBConnection;

public class BuyerDashboard extends Frame implements ActionListener {

    Label title, cropIdLabel, qtyLabel, bottomCanvas;
    TextField cropIdField, qtyField;
    TextArea cropArea;
    Button viewBtn, orderBtn, backBtn;

    String buyerId;

    public BuyerDashboard(String buyerId) {
        this.buyerId = buyerId;

        setTitle("Buyer Dashboard");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font labelFont = new Font("Arial", Font.BOLD, 22);
        Font btnFont = new Font("Arial", Font.BOLD, 22);

        title = new Label("BUYER DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 250, 60, 500, 60);
        add(title);

        cropArea = new TextArea();
        cropArea.setBounds(w/2 - 450, h/4, 900, 350);
        cropArea.setFont(new Font("Arial", Font.PLAIN, 20));
        cropArea.setEditable(false);
        add(cropArea);

        cropIdLabel = new Label("Crop ID:");
        cropIdLabel.setFont(labelFont);
        cropIdLabel.setForeground(Color.white);
        cropIdLabel.setBounds(w/2 - 350, h/4 + 380, 160, 30);
        add(cropIdLabel);

        cropIdField = new TextField();
        cropIdField.setBounds(w/2 - 150, h/4 + 380, 350, 30);
        add(cropIdField);

        qtyLabel = new Label("Quantity:");
        qtyLabel.setFont(labelFont);
        qtyLabel.setForeground(Color.white);
        qtyLabel.setBounds(w/2 - 350, h/4 + 430, 160, 30);
        add(qtyLabel);

        qtyField = new TextField();
        qtyField.setBounds(w/2 - 150, h/4 + 430, 350, 30);
        add(qtyField);

        viewBtn = new Button("VIEW CROPS");
        viewBtn.setBackground(new Color(0,255,150));
        viewBtn.setForeground(Color.black);
        viewBtn.setFont(btnFont);
        viewBtn.setBounds(w/2 - 430, h/4 + 500, 200, 45);
        viewBtn.addActionListener(this);
        add(viewBtn);

        orderBtn = new Button("PLACE ORDER");
        orderBtn.setBackground(Color.darkGray);
        orderBtn.setForeground(Color.white);
        orderBtn.setFont(btnFont);
        orderBtn.setBounds(w/2 - 100, h/4 + 500, 250, 45);
        orderBtn.addActionListener(this);
        add(orderBtn);

        backBtn = new Button("BACK");
        backBtn.setBackground(Color.gray);
        backBtn.setForeground(Color.black);
        backBtn.setFont(btnFont);
        backBtn.setBounds(w/2 + 230, h/4 + 500, 200, 45);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Buyer Operations");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 60, w, 40);
        add(bottomCanvas);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewBtn){
            loadCrops();
        }

        if(e.getSource() == orderBtn){
            placeOrder();
        }

        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }

    private void loadCrops() {
    try {
        Connection con = DBConnection.getConn();
        String q = "SELECT cropId, cropName, qty, price, farmerId FROM crops";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();

        cropArea.setText("ID\tNAME\tQTY\tPRICE\tFARMER\n-----------------------------------------------------\n");

        while(rs.next()){
            cropArea.append(
                rs.getInt("cropId") + "\t" +
                rs.getString("cropName") + "\t" +
                rs.getDouble("qty") + "\t" +
                rs.getDouble("price") + "\t" +
                rs.getString("farmerId") + "\n"
            );
        }

        rs.close();
        ps.close();
        con.close();
    }
    catch(Exception ex){
        System.out.println("Error loading crops : " + ex);
    }
}


    private void placeOrder() {
    try {
        // read from text fields
        String cropText = cropIdField.getText().trim();
        String qtyText  = qtyField.getText().trim();

        if (cropText.equals("") || qtyText.equals("")) {
            System.out.println("Enter crop id and quantity");
            return;
        }

        int cropId = Integer.parseInt(cropText);
        double qtyValue = Double.parseDouble(qtyText);

        Connection con = DBConnection.getConn();

        // optional: check crop exists
        String check = "SELECT qty FROM crops WHERE cropid = ?";
        PreparedStatement psCheck = con.prepareStatement(check);
        psCheck.setInt(1, cropId);
        ResultSet rs = psCheck.executeQuery();

        if (!rs.next()) {
            System.out.println("No crop found with this ID");
            rs.close();
            psCheck.close();
            con.close();
            return;
        }

        double available = rs.getDouble("qty");
        rs.close();
        psCheck.close();

        if (qtyValue > available) {
            System.out.println("Not enough quantity available");
            con.close();
            return;
        }

        // insert into orders
        String insertQ = "INSERT INTO orders(buyerid, cropid, qty, status) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertQ);
        ps.setString(1, buyerId);     // from login
        ps.setInt(2, cropId);         // THIS fills cropid (no NULL)
        ps.setDouble(3, qtyValue);
        ps.setString(4, "PENDING");

        int x = ps.executeUpdate();

        if (x > 0) {
            System.out.println("Order Placed Successfully");
        } else {
            System.out.println("Failed to Place Order");
        }

        // update crop qty
        String updateQ = "UPDATE crops SET qty = qty - ? WHERE cropid = ?";
        PreparedStatement psUpdate = con.prepareStatement(updateQ);
        psUpdate.setDouble(1, qtyValue);
        psUpdate.setInt(2, cropId);
        psUpdate.executeUpdate();

        psUpdate.close();
        ps.close();
        con.close();

        // clear fields
        cropIdField.setText("");
        qtyField.setText("");

    } catch (Exception ex) {
        System.out.println("Error placing order: " + ex);
    }
}

}
