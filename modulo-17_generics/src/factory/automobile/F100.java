package factory.automobile;

import factory.Factory;

public class F100 extends Factory {
    public static final String f100Name = "Ford";
    public static final String f100Model = "F100";
    public static final String f100Color = "Blue";
    public static final String f100Year = "1970";
    public static final String f100Engine = "V8 296 4.9L";

    public F100() {
        super(f100Name, f100Model, f100Color, f100Year, f100Engine);
    }
}
