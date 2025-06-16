package Models;

import Automobile.Automobile;

public class SUV extends Automobile {
    public SUV(String brand, double price) {
        super(brand, price);
    }

    @Override
    public String getModel(String brand) {
        if (brand.equalsIgnoreCase("Toyota")) {
            return "Model: { Bandeirante, 3.4 OM-324, 4P }";
        } else if (brand.equalsIgnoreCase("BMW")) {
            return "Model: { X5, 3.0 Hibrid, 4P }";
        } else if (brand.equalsIgnoreCase("Honda")) {
            return "Model: { HR-V , 1.5 I-VTEC, 4P }";
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getAutomobile(String brand) {
        return "SUV: " + this.getBrand() + ", " + this.getModel(brand) + " R$" + this.getPrice() + ",00.";
    }
}
