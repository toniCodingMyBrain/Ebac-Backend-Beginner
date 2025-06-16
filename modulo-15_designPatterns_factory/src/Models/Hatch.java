package Models;

import Automobile.Automobile;

public class Hatch extends Automobile {
    public Hatch(String brand, double price) {
        super(brand, price);
    }

    @Override
    public String getModel(String brand) {
        if (brand.equalsIgnoreCase("Toyota")) {
            return "Model: { Yaris, 1.5, 4P }";
        } else if (brand.equalsIgnoreCase("BMW")) {
            return "Model: { Serie 3, 2.0, 4P }";
        } else if (brand.equalsIgnoreCase("Honda")) {
            return "Model: { City Hatchback, 1.5 I-VTEC, 4P }";
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getAutomobile(String brand) {
        return "Hatch: " + this.getBrand() + ", " + this.getModel(brand) + " R$" + this.getPrice() + ",00.";
    }
}
