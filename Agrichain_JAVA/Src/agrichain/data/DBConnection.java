package agrichain.data;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    

    // getConn method will create and return a connection with db
    public static Connection getConn(){
        Connection conn = null;

        try{
            // it tells the jdk that we r using sqlite
            Class.forName("org.sqlite.JDBC");

            // Creates a connection to the database file agrichain.db
            // If this file does not exist, SQLite will create it automatically
            conn = DriverManager.getConnection("jdbc:sqlite:Data/agrichain.db");
        }
        catch(Exception e){
            System.out.println("DataBase Connection Error");
        }

        return conn; // returning the Connection object
    }
}
