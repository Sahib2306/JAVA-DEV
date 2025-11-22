package agrichain.model;

public class User {
    private String userId;
    private String name;
    private String password;
    private String role;

    public User(String userId, String name, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return userId + "," + name + "," + password + "," + role;
    }
    

}
