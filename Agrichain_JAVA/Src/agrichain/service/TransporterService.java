package agrichain.service;

import agrichain.model.Order;

public class TransporterService {

    public void deliverOrder(final Order order) {

        // Runnable object
        Runnable deliveryTask = new Runnable() {
            
            public void run() {
                System.out.println("Delivering order: " + order.getOrderId());

                try {
                    Thread.sleep(2000); // simulate delivery time
                } catch (InterruptedException e) {
                    System.out.println("Delivery interrupted!");
                }

                order.setStatus("Delivered");
                System.out.println("Order delivered: " + order.getOrderId());
            }
        };

        // Thread object created using Runnable
        Thread t = new Thread(deliveryTask);

        t.start();
    }
}
