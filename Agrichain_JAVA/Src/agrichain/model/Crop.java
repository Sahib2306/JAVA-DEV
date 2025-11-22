package agrichain.model;

public class Crop {
    private String cropId;
    private String name;
    private double quantity;
    private double price;

    public Crop(String cropId, String name, double quantity, double price) {
        this.cropId = cropId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCropId() {
        return cropId;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String toString() {
        return cropId + "," + name + "," + quantity + "," + price;
    }
}
