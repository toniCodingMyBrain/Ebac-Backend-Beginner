package factory;

public abstract class Factory {
    private String autoName;
    private String autoModel;
    private String autoColor;
    private String autoYear;
    private String autoEngine;

    public Factory(String autoName, String autoModel, String autoColor, String autoYear, String autoEngine) {
        this.autoName = autoName;
        this.autoModel = autoModel;
        this.autoColor = autoColor;
        this.autoYear = autoYear;
        this.autoEngine = autoEngine;
    }

    public String getAutoName() {
        return autoName;
    }

    public String getAutoModel() {
        return autoModel;
    }

    public String getAutoColor() {
        return autoColor;
    }

    public String getAutoYear() {
        return autoYear;
    }

    public String getAutoEngine() {
        return autoEngine;
    }

    @Override
    public String toString() {
        return "Brand name: " + autoName
                + ", model: " + autoModel
                + ", color: " + autoColor
                + ", fabrication year: " + autoYear
                + ", engine: " + autoEngine + ";";
    }

}
