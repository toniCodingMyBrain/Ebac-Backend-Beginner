package Automobile;

public abstract class Automobile {
    private String brand;
    private double price;

    public Automobile(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public abstract String getModel(String brand);

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}
