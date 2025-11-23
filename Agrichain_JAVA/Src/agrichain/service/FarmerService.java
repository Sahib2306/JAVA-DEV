package agrichain.service;

import agrichain.model.Crop;

public class FarmerService {

    public boolean saveCrop(Crop crop) {

        // In future replace with DB insert
        System.out.println("Saving Crop -> " + crop.getCropName());
        return true;  // just confirmation
    }

    public void showOrders() {
        System.out.println("Orders view will be added after DB");
    }
}
