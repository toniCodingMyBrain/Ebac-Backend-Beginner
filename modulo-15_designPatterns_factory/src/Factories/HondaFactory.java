package Factories;

import Automobile.Automobile;
import Factory.AutomobileFactory;
import Models.Hatch;
import Models.SUV;
import Models.Sedan;

public class HondaFactory extends AutomobileFactory {
    public Automobile createSUV() {
        return new SUV("Honda", 120000d);
    }

    @Override
    public Automobile createSedan() {
        return new Sedan("Honda", 90000d);
    }

    @Override
    public Automobile createHatch() {
        return new Hatch("Honda", 80000d);
    }
}
