package agrichain.service;

import java.sql.*;
import agrichain.data.DBConnection;

public class FarmerService {

    public boolean addCrop(String farmerId, String name, double qty, double price) {
        boolean flag = false;

        try {
            Connection con = DBConnection.getConn();

            String q = "INSERT INTO crops(farmerid, cropname, qty, price) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, farmerId);
            ps.setString(2, name);
            ps.setDouble(3, qty);
            ps.setDouble(4, price);

            int x = ps.executeUpdate();
            if(x > 0){
                flag = true;
                System.out.println("DB Insert Successful");
            }

            ps.close();
            con.close();
        }
        catch (Exception e){
            System.out.println("Add Crop Error: " + e);
        }

        return flag;
    }
}
