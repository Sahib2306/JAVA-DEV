package agrichain.data;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    // This method creates database tables when the project starts
    public static void createTables() {

        try {
            // Getting connection from DBConnection class
            Connection con = DBConnection.getConn();

            // Statement is used to run SQL commands
            Statement st = con.createStatement();

            // Creates the users table if it is not already created
            st.execute("CREATE TABLE IF NOT EXISTS users(userId TEXT PRIMARY KEY, name TEXT, password TEXT, role TEXT)");

            // Creates the crops table for storing farmer crop details
            st.execute("CREATE TABLE IF NOT EXISTS crops(cropId TEXT PRIMARY KEY, farmerId TEXT, cropName TEXT, qty REAL, price REAL)");

            // Creates the orders table for buyer orders
            st.execute("CREATE TABLE IF NOT EXISTS orders(orderId TEXT PRIMARY KEY, buyerId TEXT, cropId TEXT, qty REAL, status TEXT)");

            con.close();   // closing database connection
        }
        catch(Exception e) {
            System.out.println("Error creating tables");
        }
    }
}
