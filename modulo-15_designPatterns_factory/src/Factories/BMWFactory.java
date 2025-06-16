package Factories;

import Automobile.Automobile;
import Factory.AutomobileFactory;
import Models.Hatch;
import Models.SUV;
import Models.Sedan;

public class BMWFactory extends AutomobileFactory {
    public Automobile createSUV() {
        return new SUV("BMW", 160000d);
    }

    @Override
    public Automobile createSedan() {
        return new Sedan("BMW", 120000d);
    }

    @Override
    public Automobile createHatch() {
        return new Hatch("BMW", 100000d);
    }
}
