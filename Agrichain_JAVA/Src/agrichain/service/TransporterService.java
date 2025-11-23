package agrichain.service;

import agrichain.model.Order;

public class TransporterService {

    public void deliver(Order o) {

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Delivery started for : " + o.getOrderId());
                    Thread.sleep(3000);
                    o.setStatus("DELIVERED");
                    System.out.println("Delivery completed for : " + o.getOrderId());
                } 
                catch (Exception e) {
                    System.out.println("Delivery Interrupted");
                }
            }
        });

        t.start();
    }

    public void status(Order o) {
        System.out.println("Current status : " + o.getStatus());
    }
}
