package agrichain.gui;

import java.awt.*;
import java.awt.event.*;

public class FarmerDashboard extends Frame implements ActionListener {

    Label title, cropLabel, qtyLabel, priceLabel, bottomCanvas;
    TextField cropField, qtyField, priceField;
    Button addBtn, viewBtn, backBtn;

    public FarmerDashboard() {

        setTitle("Farmer Dashboard");
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.black);
        setVisible(true);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        int w = s.width;
        int h = s.height;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        Font labelFont = new Font("Arial", Font.BOLD, 22);

        title = new Label("FARMER DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(new Color(0,255,150));
        title.setBounds(w/2 - 250, h/6, 500, 60);
        add(title);

        cropLabel = new Label("Crop Name:");
        cropLabel.setFont(labelFont);
        cropLabel.setForeground(Color.white);
        cropLabel.setBounds(w/2 - 300, h/3 - 20, 150, 30);
        add(cropLabel);

        cropField = new TextField();
        cropField.setBounds(w/2 - 100, h/3 - 20, 350, 30);
        add(cropField);

        qtyLabel = new Label("Quantity:");
        qtyLabel.setFont(labelFont);
        qtyLabel.setForeground(Color.white);
        qtyLabel.setBounds(w/2 - 300, h/3 + 30, 150, 30);
        add(qtyLabel);

        qtyField = new TextField();
        qtyField.setBounds(w/2 - 100, h/3 + 30, 350, 30);
        add(qtyField);

        priceLabel = new Label("Price:");
        priceLabel.setFont(labelFont);
        priceLabel.setForeground(Color.white);
        priceLabel.setBounds(w/2 - 300, h/3 + 80, 150, 30);
        add(priceLabel);

        priceField = new TextField();
        priceField.setBounds(w/2 - 100, h/3 + 80, 350, 30);
        add(priceField);

        addBtn = new Button("ADD CROP");
        addBtn.setBackground(new Color(0,255,150));
        addBtn.setForeground(Color.black);
        addBtn.setFont(labelFont);
        addBtn.setBounds(w/2 - 260, h/3 + 160, 200, 45);
        addBtn.addActionListener(this);
        add(addBtn);

        viewBtn = new Button("VIEW CROPS");
        viewBtn.setBackground(Color.darkGray);
        viewBtn.setForeground(Color.white);
        viewBtn.setFont(labelFont);
        viewBtn.setBounds(w/2 + 40, h/3 + 160, 200, 45);
        viewBtn.addActionListener(this);
        add(viewBtn);

        backBtn = new Button("BACK");
        backBtn.setBackground(Color.gray);
        backBtn.setForeground(Color.black);
        backBtn.setFont(labelFont);
        backBtn.setBounds(w/2 - 100, h/3 + 240, 200, 45);
        backBtn.addActionListener(this);
        add(backBtn);

        bottomCanvas = new Label("AgriChain — Farmer Operations");
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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            System.out.println("Add crop clicked");
        }
        if(e.getSource() == viewBtn){
            System.out.println("View crops clicked");
        }
        if(e.getSource() == backBtn){
            new LoginGui();
            dispose();
        }
    }
}
