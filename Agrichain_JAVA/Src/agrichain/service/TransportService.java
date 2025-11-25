package agrichain.service;

import java.sql.*;
import agrichain.model.Order;
import agrichain.data.DBConnection;

public class TransportService {

    // Delivering the order and using multithreading
    public void deliver(Order o){

       Thread t = new Thread(new Runnable() {
        
        public void run(){
            try {
                // delivery progress bar having sleep function 
                for(int i = 0;i <=100;i+=20){
                    System.out.println("Delivery Progress -> "+i);
                    Thread.sleep(500); // i have given the pause for 0.5 seconnds . the print statement will take a pause for 0.5 secs

                }

                // updating the database
                Connection conn = DBConnection.getConn();
                PreparedStatement ps = conn.prepareStatement("update orders set status=? where orderId=?");

                ps.setString(1, "Delivered");
                ps.setString(2, o.getOrderId());

                ps.executeUpdate();

                conn.close();
            } catch (Exception e) {
                System.out.println("Transport Error");
            }
        }
       });

       t.start(); // thread starting
    }
}