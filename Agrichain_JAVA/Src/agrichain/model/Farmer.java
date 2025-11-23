package agrichain.model;

public class Farmer extends User {

    public Farmer(String userId, String name, String password) {
        super(userId, name, password, "FARMER");
    }
}
