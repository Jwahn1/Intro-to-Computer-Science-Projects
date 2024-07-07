import java.util.ArrayList;
public class Car extends CarModel{
    private final int plateNumber;
    private final ArrayList<Double> trips = new ArrayList<>();//stores each successful trip's distance variable

    //constructor
    public Car(String modelName, int plateNumber){
        super();
        this.modelName = modelName;
        this.plateNumber = plateNumber;
        this.fuelEconomy = 0.0;
        this.tankCapacity = 0.0;
    }

    //getter
    public int getPlateNumber(){return plateNumber;}
    public String getModelName() {return modelName;}
    public double getTankCapacity(){return tankCapacity;}
    public ArrayList<Double> g  etTrips() {return trips;}

    //setters
    public void setFuelEconomy(double newFuelEconomy) {this.fuelEconomy = newFuelEconomy;}
    public void setTankCapacity(double newTankCapacity){this.tankCapacity = newTankCapacity;}

    public void setTrips(double newTrip) {this.trips.add(newTrip);}

    //Function returns the fuel that would be used by the car in terms of the distance inputted
    public double tripPossible(double distance){
        return (distance/100.0)*fuelEconomy;
    }
}
