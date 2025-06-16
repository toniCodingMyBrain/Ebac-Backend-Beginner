package factory.automobile;

import factory.Factory;

public class C14 extends Factory {
    public static final String c14Name = "Chevrolet";
    public static final String c14Model = "C14";
    public static final String c14Color = "Red";
    public static final String c14Year = "1970";
    public static final String c14Engine = "L6 4.1L";

    public C14() {
        super(c14Name, c14Model, c14Color, c14Year, c14Engine);
    }

}
