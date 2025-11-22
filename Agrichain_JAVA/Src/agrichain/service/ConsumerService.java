package agrichain.service;

import agrichain.model.Crop;
import agrichain.model.Order;

public class ConsumerService {

    public Order createPurchase(String orderId, String consumerId, Crop crop, double quantity) {

        return new Order(orderId,consumerId,crop.getCropId(),quantity,"PENDING");
    }

    public void updateOrderStatus(Order order, String newStatus) {
        order.setStatus(newStatus);
    }

    // Used by JDBC layer to delete order from DB
    public String cancelOrder(String orderId) {
        return orderId;
    }
}
