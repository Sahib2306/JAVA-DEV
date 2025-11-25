package agrichain.service;

import java.sql.*;
import agrichain.data.DBConnection;
import agrichain.model.Crop;

public class FarmerService {

    // method to add new crop in the tables
    public void addCrop(Crop c){ //accessing the constructor of crop class

        try{
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("Insert into crops values(?,?,?,?,?");

            ps.setString(1,c.getCropId());
            ps.setString(2, c.getFarmerId());
            ps.setString(3, c.getCropName());
            ps.setDouble(4, c.getQuantity());
            ps.setDouble(5,c.getPrice());

            ps.executeUpdate();
            conn.close();



        }

        catch(Exception e){
            System.out.println("Failed to Add crop!");
        }
    }
}