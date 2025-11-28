package agrichain.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import agrichain.data.DBConnection;

public class UserService {

    public boolean registerUser(String id, String name, String pass, String role) {
        boolean flag = false;
        try {
            Connection con = DBConnection.getConn();
            PreparedStatement pst = con.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, pass);
            pst.setString(4, role);

            int r = pst.executeUpdate();
            if (r > 0) flag = true;
            con.close();
        } catch(Exception e) {
            System.out.println("Register Error");
        }
        return flag;
    }

    public boolean loginUser(String id, String pass, String role) {
        boolean flag = false;
        try {
            Connection con = DBConnection.getConn();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE id=? AND pass=? AND role=?");
            pst.setString(1, id);
            pst.setString(2, pass);
            pst.setString(3, role);

            ResultSet rs = pst.executeQuery();
            if(rs.next()) flag = true;
            con.close();
        } catch(Exception e) {
            System.out.println("Login Error");
        }
        return flag;
    }
}
