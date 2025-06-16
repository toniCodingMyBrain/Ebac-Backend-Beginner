package Factory;

import Automobile.Automobile;

public abstract class AutomobileFactory {
    public abstract Automobile createSedan();

    public abstract Automobile createSUV();

    public abstract Automobile createHatch();

    public Automobile createAutomobile(String model) {
        if (model.equalsIgnoreCase("sedan")) {
            return createSedan();
        } else if (model.equalsIgnoreCase("suv")) {
            return createSUV();
        } else if (model.equalsIgnoreCase("hatch")) {
            return createHatch();
        } else {
            throw new IllegalArgumentException("Invalid model: " + model + ", please repeat the process correctly.");
        }
    }
}
