import java.util.Objects;

public class CarModel {
    protected String modelName;
    protected double fuelEconomy;
    protected double tankCapacity;

    public CarModel(String modelName, double fuelEconomy, double tankCapacity) {
        this.modelName = modelName;
        this.fuelEconomy = fuelEconomy;
        this.tankCapacity = tankCapacity;
    }

    public CarModel() {

    }

    public String modelName() {
        return modelName;
    }

    public double fuelEconomy() {
        return fuelEconomy;
    }

    public double tankCapacity() {
        return tankCapacity;
    }
}

