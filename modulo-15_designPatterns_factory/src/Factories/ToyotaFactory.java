package Factories;

import Automobile.Automobile;
import Factory.AutomobileFactory;
import Models.Hatch;
import Models.SUV;
import Models.Sedan;

public class ToyotaFactory extends AutomobileFactory {
    public Automobile createSUV() {
        return new SUV("Toyota", 130000d);
    }

    @Override
    public Automobile createSedan() {
        return new Sedan("Toyota", 100000d);
    }

    @Override
    public Automobile createHatch() {
        return new Hatch("Toyota", 80000d);
    }
}
