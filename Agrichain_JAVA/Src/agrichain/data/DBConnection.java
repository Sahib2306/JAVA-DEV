package agrichain.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConn() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Src/agrichain/data/agrichain.sqlite");
            System.out.println("DB Connected");
        }
        catch(Exception e) {
            System.out.println("DB NOT CONNECTED");
            e.printStackTrace();
        }
        return con;
    }
}
