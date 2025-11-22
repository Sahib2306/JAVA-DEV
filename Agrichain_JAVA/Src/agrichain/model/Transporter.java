package agrichain.model;

public class Transporter extends User {
    private String vehicleId;
    private String assignedOrderId; 

    public Transporter(String userId, String name, String password, String vehicleId) {
        super(userId, name, password, "TRANSPORTER");
        this.vehicleId = vehicleId;
        this.assignedOrderId = null;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setAssignedOrderId(String orderId) {
        this.assignedOrderId = orderId;
    }

    public String getAssignedOrderId() {
        return assignedOrderId;
    }
}
