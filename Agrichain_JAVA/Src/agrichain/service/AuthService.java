package agrichain.service;

import java.io.FileReader;
import java.io.FileWriter;

public class AuthService {

    String path = "data/users.txt";

    public boolean login(String id, String pass, String role) {

        boolean flag = false;
        String temp = "";

        try {
            FileReader fr = new FileReader(path);
            int ch;

            
            while ((ch = fr.read()) != -1) {
                temp = temp + (char) ch;
            }

            fr.close();

            // split lines
            String lines[] = temp.split("\n");

            for (int i = 0; i < lines.length; i++) {

                String arr[] = lines[i].split(",");

                // arr[0]=id, arr[1]=name, arr[2]=pass, arr[3]=role
                if (arr.length == 4) {
                    if (id.equals(arr[0]) && pass.equals(arr[2]) &&
                        role.equalsIgnoreCase(arr[3])) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("File Read Error");
        }

        return flag;
    }

    
    public void registerUser(String line) {
        try {
            FileWriter fw = new FileWriter(path, true); 
            fw.write("\n" + line);
            fw.close();
            System.out.println("User registered");
        }
        catch (Exception e) {
            System.out.println("File Write Error");
        }
    }
}
