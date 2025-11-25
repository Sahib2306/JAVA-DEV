package agrichain.service;

import java.sql.*;
import agrichain.data.DBConnection;
import agrichain.model.Order;

public class BuyerService {

    // placing new order
    public void placeOrder(Order o){
        try{
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?");

            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getBuyerId());
            ps.setString(3, o.getCropId());
            ps.setDouble(4, o.getQuantity());
            ps.setString(5, o.getStatus());
        }
        catch(Exception e){
            System.out.println("Failed to Place Order !");
        }
    }
}