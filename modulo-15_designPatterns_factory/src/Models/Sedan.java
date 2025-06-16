package Models;

import Automobile.Automobile;

public class Sedan extends Automobile {
    public Sedan(String brand, double price) {
        super(brand, price);
    }

    @Override
    public String getModel(String brand) {
        if (brand.equalsIgnoreCase("Toyota")) {
            return "Model: { Corolla, 2.0, 4P }";
        } else if (brand.equalsIgnoreCase("BMW")) {
            return "Model: { Serie 3, 2.0, 4P }";
        } else if (brand.equalsIgnoreCase("Honda")) {
            return "Model: { Civic, 2.0, 4P }";
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getAutomobile(String brand) {
        return "Sedan: " + this.getBrand() + " " + this.getModel(brand) + " R$" + this.getPrice() + ",00.";
    }
}
