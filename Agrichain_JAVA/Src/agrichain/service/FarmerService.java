package agrichain.service;

import agrichain.model.Crop;

public class FarmerService {

    
    public Crop createCrop(String cropId, String name, int quantity, double price) {
        return new Crop(cropId, name, quantity, price);
    }

    
    public Crop updateCrop(Crop crop, int newQuantity) {
        crop.setQuantity(newQuantity);
        return crop;
    }

    
    public String deleteCrop(String cropId) {
        return cropId; 
    }

}
