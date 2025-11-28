package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import agrichain.data.DBConnection;

public class ConsumerDashboard extends Frame implements ActionListener {

    Label title, bottomCanvas;
    TextArea orderArea;
    Button viewBtn, backBtn;

    String consumerId;

    public ConsumerDashboard(String consumerId){
        this.consumerId = consumerId;

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
        title.setBounds(w/2 - 350, 60, 700, 60);
        add(title);

        orderArea = new TextArea();
        orderArea.setBounds(w/2 - 450, h/4, 900, 400);
        orderArea.setFont(new Font("Arial", Font.PLAIN, 20));
        orderArea.setEditable(false);
        add(orderArea);

        viewBtn = new Button("VIEW HISTORY");
        viewBtn.setBackground(new Color(0,255,150));
        viewBtn.setForeground(Color.black);
        viewBtn.setFont(btnFont);
        viewBtn.setBounds(w/2 - 250, h/4 + 450, 220, 45);
        viewBtn.addActionListener(this);
        add(viewBtn);

        backBtn = new Button("BACK");
        backBtn.setBackground(Color.darkGray);
        backBtn.setForeground(Color.white);
        backBtn.setFont(btnFont);
        backBtn.setBounds(w/2 + 50, h/4 + 450, 200, 45);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Consumer Order History");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 60, w, 40);
        add(bottomCanvas);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){ dispose(); }
        });
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == viewBtn){
            loadDeliveredOrders();
        }

        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }

    private void loadDeliveredOrders(){
        try {
            Connection con = DBConnection.getConn();
            String q = "SELECT orderid, cropid, qty, status FROM orders WHERE buyerid=? AND status='DELIVERED'";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, consumerId);

            ResultSet rs = ps.executeQuery();

            orderArea.setText("ORDER\tCROP\tQTY\tSTATUS\n----------------------------------------------\n");

            while(rs.next()){
                orderArea.append(
                        rs.getInt("orderid") + "\t" +
                        rs.getString("cropid") + "\t" +
                        rs.getDouble("qty") + "\t" +
                        rs.getString("status") + "\n"
                );
            }

            rs.close();
            ps.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println("Error loading delivered orders : " + ex);
        }
    }

    public static void main(String[] args) {
        new ConsumerDashboard("C01");
    }
}
