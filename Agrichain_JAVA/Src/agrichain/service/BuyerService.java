package agrichain.service;

import agrichain.model.Order;

public class BuyerService {

    public boolean makeOrder(Order o) {

        System.out.println("Placing order for crop id : " + o.getCropId());
        return true;
    }

    public void showCrops() {
        System.out.println("Crop list will show here after DB");
    }
}
