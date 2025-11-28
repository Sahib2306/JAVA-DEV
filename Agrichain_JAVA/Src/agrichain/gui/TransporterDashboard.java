package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import agrichain.data.DBConnection;

public class TransporterDashboard extends Frame implements ActionListener {

    Label title, orderIdLabel, bottomCanvas, msgLabel;
    TextField orderIdField;
    TextArea orderArea;
    Button viewBtn, updateBtn, backBtn;
    String transporterId;

    public TransporterDashboard(String transporterId){
        this.transporterId = transporterId;

        setTitle("Transporter Dashboard");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font labelFont = new Font("Arial", Font.BOLD, 22);

        title = new Label("TRANSPORTER DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 350, 60, 700, 60);
        add(title);

        orderArea = new TextArea();
        orderArea.setBounds(w/2 - 400, h/4, 800, 350);
        orderArea.setFont(new Font("Arial", Font.PLAIN, 20));
        orderArea.setEditable(false);
        add(orderArea);

        orderIdLabel = new Label("Order ID:");
        orderIdLabel.setFont(labelFont);
        orderIdLabel.setForeground(Color.white);
        orderIdLabel.setBounds(w/2 - 300, h/4 + 380, 150, 30);
        add(orderIdLabel);

        orderIdField = new TextField();
        orderIdField.setBounds(w/2 - 100, h/4 + 380, 300, 30);
        add(orderIdField);

        viewBtn = new Button("VIEW ORDERS");
        viewBtn.setBounds(w/2 - 350, h/4 + 450, 200, 45);
        viewBtn.setBackground(new Color(0,255,150));
        viewBtn.setForeground(Color.black);
        viewBtn.addActionListener(this);
        add(viewBtn);

        updateBtn = new Button("UPDATE STATUS");
        updateBtn.setBounds(w/2 - 50, h/4 + 450, 250, 45);
        updateBtn.setBackground(Color.darkGray);
        updateBtn.setForeground(Color.white);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new Button("BACK");
        backBtn.setBounds(w/2 + 300, h/4 + 450, 200, 45);
        backBtn.setBackground(Color.gray);
        backBtn.setForeground(Color.black);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Transporter Operations");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 60, w, 40);
        add(bottomCanvas);

        msgLabel = new Label("");
        msgLabel.setAlignment(Label.CENTER);
        msgLabel.setForeground(Color.green);
        msgLabel.setBounds(w/2 - 200, h/4 + 520, 500, 40);
        add(msgLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){ dispose(); }
        });
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == viewBtn){
            loadOrders();
        }

        if(e.getSource() == updateBtn){
            startDelivery();
        }

        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }

    private void loadOrders() {
        try {
            Connection con = DBConnection.getConn();
            String q = "SELECT orderId, buyerId, cropId, qty, status FROM orders WHERE status='PENDING'";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            orderArea.setText("ID\tBUYER\tCROP\tQTY\tSTATUS\n-------------------------------------------\n");

            while(rs.next()){
                orderArea.append(
                    rs.getInt("orderId") + "\t" +
                    rs.getString("buyerId") + "\t" +
                    rs.getInt("cropId") + "\t" +
                    rs.getDouble("qty") + "\t" +
                    rs.getString("status") + "\n"
                );
            }

            rs.close();
            ps.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println("Error loading orders : " + ex);
        }
    }

    private void startDelivery() {
        String id = orderIdField.getText().trim();

        new Thread(() -> {
            for(int i=10; i<=100; i+=10){
                msgLabel.setText("Delivering... " + i + "%");
                try { Thread.sleep(700); } catch(Exception e){}
            }
            msgLabel.setText("DELIVERY COMPLETED!");

            updateStatus(id);
        }).start(); 
    }

    private void updateStatus(String id){
        try {
            Connection con = DBConnection.getConn();
            String q = "UPDATE orders SET status='DELIVERED' WHERE orderId=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, Integer.parseInt(id));

            int x = ps.executeUpdate();

            if(x > 0)
                System.out.println("Status Updated Successfully");
            else
                System.out.println("Failed to Update");

            ps.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println("Error updating delivery : " + ex);
        }
    }
}
