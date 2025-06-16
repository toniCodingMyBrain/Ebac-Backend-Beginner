package factory.automobile;

import factory.Factory;

public class Galaxie extends Factory {
    public static final String galaxieName = "Ford";
    public static final String galaxieModel = "Galaxie 500";
    public static final String galaxieColor = "Marine Blue";
    public static final String galaxieYear = "1969";
    public static final String galaxieEngine = "V8 296 4.7L";

    public Galaxie() {
        super(galaxieName, galaxieModel, galaxieColor, galaxieYear, galaxieEngine);
    }
}
