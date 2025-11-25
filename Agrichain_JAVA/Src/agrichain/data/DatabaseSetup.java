package agrichain.data;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {

        try {
            Connection con = DBConnection.getConn();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS users(userId TEXT PRIMARY KEY, name TEXT, password TEXT, role TEXT)");
            st.execute("CREATE TABLE IF NOT EXISTS crops(cropId TEXT PRIMARY KEY, farmerId TEXT, cropName TEXT, qty REAL, price REAL)");
            st.execute("CREATE TABLE IF NOT EXISTS orders(orderId TEXT PRIMARY KEY, buyerId TEXT, cropId TEXT, qty REAL, status TEXT)");

            System.out.println("Tables Ready");
            con.close();
        }
        catch(Exception e) {
            System.out.println("Table Creation Failed");
        }
    }
}
