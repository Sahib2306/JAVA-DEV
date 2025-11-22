package agrichain.service;

import agrichain.model.Crop;
import agrichain.model.Order;

public class BuyerService {

    public Order createOrder(String orderId, String buyerId, Crop crop, double quantity) {
        
        return new Order(orderId,buyerId,crop.getCropId(),  quantity,"PENDING");
    }

    public void updateOrderStatus(Order order, String newStatus) {
        order.setStatus(newStatus);
    }

    public String cancelOrder(String orderId) {
        return orderId;
    }
}
