package agrichain.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import agrichain.data.DBConnection;

public class ViewCropsDashboard extends Frame implements ActionListener {

    Label title, bottomCanvas;
    TextArea cropArea;
    Button backBtn;
    String farmerId;

    public ViewCropsDashboard(String farmerId) {
        this.farmerId = farmerId;

        setTitle("Crop Records");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font textFont = new Font("Arial", Font.PLAIN, 20);

        title = new Label("CROP LIST");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 150, 60, 300, 60);
        add(title);

        cropArea = new TextArea();
        cropArea.setBounds(w/2 - 350, h/4, 700, 400);
        cropArea.setFont(textFont);
        cropArea.setEditable(false);
        add(cropArea);

        backBtn = new Button("BACK");
        backBtn.setBackground(Color.gray);
        backBtn.setForeground(Color.black);
        backBtn.setFont(new Font("Arial", Font.BOLD, 22));
        backBtn.setBounds(w/2 - 80, h/4 + 450, 160, 45);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Crop Records View");
        bottomCanvas.setAlignment(Label.CENTER);
        bottomCanvas.setForeground(Color.gray);
        bottomCanvas.setBounds(0, h - 60, w, 40);
        add(bottomCanvas);

        loadCrops();   // show crop data

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }

    private void loadCrops() {
        try {
            Connection con = DBConnection.getConn();

            String q = "SELECT crop_name, quantity, price FROM crops WHERE farmer_id = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, farmerId);

            ResultSet rs = ps.executeQuery();

            cropArea.setText("NAME\t\tQTY\tPRICE\n-------------------------------------------\n");

            while (rs.next()) {
                cropArea.append(
                    rs.getString(1) + "\t\t" +
                    rs.getDouble(2) + "\t" +
                    rs.getDouble(3) + "\n"
                );
            }

            rs.close();
            ps.close();
            con.close();
        }
        catch(Exception e){
            System.out.println("Error Loading Crops");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            new FarmerDashboard(farmerId);
            dispose();
        }
    }
}
