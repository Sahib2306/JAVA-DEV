package agrichain.main;

import java.sql.*;
import agrichain.*;

public class AgriChainMain {

    

public static void main(String[] args) {
    try {
        Connection conn = agrichain.data.DBConnection.getConn();
        if(conn != null) {
            System.out.println("Connected to database successfully!");
            conn.close();
        } else {
            System.out.println("Failed to connect.");
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}