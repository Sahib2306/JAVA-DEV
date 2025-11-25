package agrichain.model;

public class Order {

    public String orderId;
    public String buyerId;
    public String cropId;
    public double quantity;
    public String status;

    public Order(String orderId, String buyerId, String cropId, double quantity, String status) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.cropId = cropId;
        this.quantity = quantity;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getCropId() {
        return cropId;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
