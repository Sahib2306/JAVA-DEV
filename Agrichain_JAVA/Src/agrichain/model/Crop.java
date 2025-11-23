package agrichain.model;

public class Crop {

    private String cropId;
    private String cropName;
    private double quantity;
    private double price;

    public Crop(String cropId, String cropName, double quantity, double price) {
        this.cropId = cropId;
        this.cropName = cropName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCropId() {
        return cropId;
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

    @Override
    public String toString() {
        return cropId + "," + cropName + "," + quantity + "," + price;
    }
}
