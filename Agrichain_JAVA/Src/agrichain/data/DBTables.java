package agrichain.data;

import java.sql.Connection;
import java.sql.Statement;

public class DBTables {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConn();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS users(" +
                    "id TEXT PRIMARY KEY," +
                    "name TEXT," +
                    "pass TEXT," +
                    "role TEXT)");

            st.execute("CREATE TABLE IF NOT EXISTS crops(" +
                    "cropId TEXT PRIMARY KEY," +
                    "farmerId TEXT," +
                    "cropName TEXT," +
                    "qty REAL," +
                    "price REAL)");

            st.execute("CREATE TABLE IF NOT EXISTS orders(" +
                    "orderId TEXT PRIMARY KEY," +
                    "buyerId TEXT," +
                    "cropId TEXT," +
                    "qty REAL," +
                    "status TEXT)");

            st.execute("CREATE TABLE IF NOT EXISTS delivery(" +
                    "orderId TEXT," +
                    "transporterId TEXT," +
                    "status TEXT)");

            System.out.println("TABLES CREATED SUCCESSFULLY");
            con.close();
        }
        catch (Exception e){
            System.out.println("Error Creating Tables");
        }
    }
}
