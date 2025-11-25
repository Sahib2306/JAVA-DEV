package agrichain.model;

public class Crop{
    
    public String cropId;
    public String farmerId;
    public String cropName;
    public double quantity;
    public double price;

    public Crop(String cropId, String farmerId, String cropName, double quantity, double price){
        this.cropId = cropId;
        this.farmerId = farmerId;
        this.cropName = cropName;
        this.quantity = quantity;
        this.price = price;

    }
    public String getCropId() {
        return cropId;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public String getCropName() {
        return cropName;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

}