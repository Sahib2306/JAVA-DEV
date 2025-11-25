package agrichain.service;

import java.sql.*;
import agrichain.data.DBConnection;

public class ConsumerService {

    public ResultSet viewHistory(String id){
        ResultSet rs = null;

        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("Select * from orders where buyerId=?");

            ps.setString(1, id);
            ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            System.out.println("Unable to Fetch the History!");
        }
        return rs;
    }
}