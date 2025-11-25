package agrichain.model;

public class Transporter extends User {

    public  String vehicleId;

    public Transporter(String userId, String name, String password, String vehicleId) {
        super(userId, name, password, "TRANSPORTER");
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
