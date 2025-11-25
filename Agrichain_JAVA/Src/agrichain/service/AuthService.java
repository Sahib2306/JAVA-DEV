package agrichain.service;

import java.sql.*;
import agrichain.data.DBConnection;

public class AuthService{

    // checking the login credentials from database
    public boolean login(String id, String pass, String role){
        boolean isValid = false;

        try{
            // getting the connection from databse 
            Connection conn  = DBConnection.getConn();

            // PreparedStatement is used when we want to send values (?)
            // ? question mark will be replaced by the values 
            PreparedStatement ps = conn.prepareStatement("Select * from users where userId=? AND password=? AND role=?");

            ps.setString(1,id); // puts the id into ?
            ps.setString(2, pass);
            ps.setString(3, role);


            ResultSet rs = ps.executeQuery();

            if(rs.next()){ // if any row matches the credentials then the login will work 
                isValid = true; 
            }

            conn.close();

        }
        catch(Exception e){
            System.out.println("Login Failed!");
        }
        return isValid;
    }

    public void register(String id, String name , String pass, String role){

        try{
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?)");

            ps.setString(1, id);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, role);

            ps.executeUpdate(); // it is used for inserting data , updating the data , deleting the data
            conn.close();




        }
        catch(Exception e){
            System.out.println("Registration Failed!");
        }
    }
}