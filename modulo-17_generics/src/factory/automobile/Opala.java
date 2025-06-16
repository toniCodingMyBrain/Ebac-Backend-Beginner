package factory.automobile;

import factory.Factory;

public class Opala extends Factory {
    public static final String opalaName = "Chevrolet";
    public static final String opalaModel = "Opala";
    public static final String opalaColor = "Black";
    public static final String opalaYear = "1970";
    public static final String opalaEngine = "L6 4.1L";

    public Opala() {
        super(opalaName, opalaModel, opalaColor, opalaYear, opalaEngine);
    }
}
