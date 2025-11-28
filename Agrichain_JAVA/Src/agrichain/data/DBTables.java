package agrichain.data;

import java.sql.Connection;
import java.sql.Statement;

public class DBTables {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConn();
            Statement st = con.createStatement();

            // Drop if exists
            st.execute("DROP TABLE IF EXISTS orders");

            // Correct table
            st.execute(
                "CREATE TABLE IF NOT EXISTS orders(" +
                "orderId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "buyerId TEXT," +
                "cropId INTEGER," +
                "qty REAL," +
                "status TEXT)"
            );

            System.out.println("Orders Table Created");
            st.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("Error creating table: " + ex);
        }
    }
}
