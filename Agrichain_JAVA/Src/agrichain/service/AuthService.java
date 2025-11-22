// package agrichain.service;
// import agrichain.model.User;

// public class AuthService {
    
//     public User Login(String userId, String password){
//         // Farmer 
//         if(userId.equals("0001") && password.equals("Farmer")){
//             return new User("0001", "Sahib", "Farmer", "Farmer");
//         }
//         // Buyer
//         if(userId.equals("0002") && password.equals("Buyer")){
//             return new User("0002", "Noor", "Buyer", "Buyer");
//         }
//         // Consumer
//         if(userId.equals("0003") && password.equals("Consumer")){
//             return new User("0003", "Raman", "Consumer", "Consumer");
//         }

//         // Transporter
//         if(userId.equals("0004") && password.equals("Transporter")){
//             return new User("0004", "Shivang", "Transporter", "Transporter");
//         }

//         // i have used null because if the user fails to login then it should Display "Login Failed!!"
//         // return null;
//         // or
//         return new User("NONE", "Invalid", "", "");

//     }
// }


package agrichain.service;

public class AuthService {

    // VERY SIMPLE DUMMY LOGIN (hardcoded example)
    public boolean login(String userId, String password, String role) {

        // Accept only 1 sample login
        if (userId.equals("1001") && password.equals("pass") && role.equals("FARMER")) {
            return true;
        }

        if (userId.equals("2001") && password.equals("pass") && role.equals("BUYER")) {
            return true;
        }

        if (userId.equals("3001") && password.equals("pass") && role.equals("CONSUMER")) {
            return true;
        }

        if (userId.equals("4001") && password.equals("pass") && role.equals("TRANSPORTER")) {
            return true;
        }

        return false;  // wrong login
    }
}
