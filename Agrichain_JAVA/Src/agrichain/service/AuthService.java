package agrichain.service;

public class AuthService {

    // Hardcoded sample users for login (temporary until JDBC)
    public boolean login(String id, String pass, String role) {

        // sample manual login records
        if(id.equals("1001") && pass.equals("pass") && role.equalsIgnoreCase("FARMER")) {
            return true;
        }
        if(id.equals("2001") && pass.equals("1234") && role.equalsIgnoreCase("BUYER")) {
            return true;
        }
        if(id.equals("3001") && pass.equals("1111") && role.equalsIgnoreCase("CONSUMER")) {
            return true;
        }
        if(id.equals("4001") && pass.equals("999") && role.equalsIgnoreCase("TRANSPORTER")) {
            return true;
        }

        return false;  // for wrong credentials
    }

    // register removed since no file handling
}
