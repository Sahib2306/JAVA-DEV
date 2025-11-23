package agrichain.model;

public class Buyer extends User {

    public Buyer(String userId, String name, String password) {
        super(userId, name, password, "BUYER");
    }
}
